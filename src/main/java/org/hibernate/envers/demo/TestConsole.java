/*
 * Envers. http://www.jboss.org/envers
 *
 * Copyright 2008  Red Hat Middleware, LLC. All rights reserved.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT A WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License, v.2.1 along with this distribution; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 *
 * Red Hat Author(s): Adam Warski
 */
package org.hibernate.envers.demo;

import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MXBean;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.jmx.StatisticsService;
import org.hibernate.stat.Statistics;

/**
 * @author Adam Warski (adam at warski dot org)
 */
public class TestConsole {
	private final EntityManager	entityManager;

	public TestConsole(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	private String convertString(String s, String def) {
		if ("NULL".equals(s)) {
			return null;
		}
		if ("".equals(s)) {
			return def;
		}
		return s;
	}

	private int convertStringToInteger(String s, int def) {
		if ("".equals(s)) {
			return def;
		}
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			System.err.println("Invalid number, returning 0.");
			return 0;
		}
	}

	private void printPerson(StringBuilder sb, Person p) {
		sb.append("id = ").append(p.getId()).append(", name = ").append(p.getName()).append(", surname = ").append(p.getSurname());

		Address a = p.getAddress();
		if (a != null) {
			sb.append(", address = <").append(a.getId()).append("> ").append(a.getStreetName()).append(" ").append(a.getHouseNumber()).append("/").append(a.getFlatNumber());
		}
	}

	@SuppressWarnings({ "unchecked" })
	private void printPersons(StringBuilder sb) {
		EntityManager em = this.entityManager;
		//		em.flush();
		//		em.getTransaction().commit();

		Query q = em.createQuery("select p from Person p order by p.id");

		//		// Gestion cache L2
		//		EntityManagerFactory emf = em.getEntityManagerFactory();
		//		Cache cache = emf.getCache();
		//		Boolean isInCache = cache.contains(Person.class, 4);
		//		System.out.println("Person "+4+" in cache: "+isInCache);
		//		isInCache = cache.contains(Person.class, "4");
		//		System.out.println("Person "+4+" in cache: "+isInCache);
		//		if (isInCache) {
		//			cache.evictAll();
		//		}
		//		q.setHint("javax.persistence.cache.retrieveMode", BYPASS");
		//		q.setHint("javax.persistence.cache.retrieveMode", "BYPASS");


		List<Person> persons = q.getResultList();
		sb.append("Persons:\n");
		for (Person p : persons) {
			//			this.entityManager.refresh(p);
			this.printPerson(sb, p);
			sb.append("\n");
		}
		//		em.getTransaction().begin();
	}

	private void printPersonHistory(StringBuilder sb, int personId) {
		AuditReader reader = AuditReaderFactory.get(this.entityManager);

		List personHistory = reader.createQuery().forRevisionsOfEntity(Person.class, false, true).add(AuditEntity.id().eq(personId)).getResultList();

		if (personHistory.size() == 0) {
			sb.append("A person with id ").append(personId).append(" does not exist.\n");
		} else {
			for (Object historyObj : personHistory) {
				Object[] history = (Object[]) historyObj;
				DefaultRevisionEntity revision = (DefaultRevisionEntity) history[1];
				sb.append("revision = ").append(revision.getId()).append(", ");
				this.printPerson(sb, (Person) history[0]);
				sb.append(" (").append(revision.getRevisionDate()).append(")\n");
			}
		}
	}

	private void printPersonAtRevision(StringBuilder sb, int personId, int revision) {
		AuditReader reader = AuditReaderFactory.get(this.entityManager);

		Person p = reader.find(Person.class, personId, revision);
		if (p == null) {
			sb.append("This person does not exist at that revision.");
		} else {
			this.printPerson(sb, p);
		}
	}

	private void readAndSetAddress(Scanner scanner, Person p) {
		Address old = p.getAddress();

		String input = scanner.nextLine();
		if ("NULL".equals(input)) {
			p.setAddress(null);
			if (old != null) {
				old.getPersons().remove(p);
			}
		} else if ("".equals(input)) {
		} else {
			try {
				Integer id = Integer.valueOf(input);

				Address a = this.entityManager.find(Address.class, id);

				if (a == null) {
					System.err.println("Unknown address id, setting to NULL.");
					p.setAddress(null);
					if (old != null) {
						old.getPersons().remove(p);
					}
				} else {
					p.setAddress(a);

					a.getPersons().add(p);

					if (old != null) {
						old.getPersons().remove(p);
					}
				}
			} catch (NumberFormatException e) {
				System.err.println("Invalid address id, setting to NULL.");
				p.setAddress(null);
				if (old != null) {
					old.getPersons().remove(p);
				}
			}
		}
	}

	private Person readNewPerson(PrintStream out, Scanner scanner) {
		Person p = new Person();

		out.print("Person name (NULL for null): ");
		p.setName(this.convertString(scanner.nextLine(), ""));

		out.print("Person surname (NULL for null): ");
		p.setSurname(this.convertString(scanner.nextLine(), ""));

		out.print("Person address id (NULL for null): ");
		this.readAndSetAddress(scanner, p);

		return p;
	}

	private void readModifyPerson(PrintStream out, Scanner scanner, int personId) {
		Person current = this.entityManager.find(Person.class, personId);

		if (current == null) {
			out.println("Person with id " + personId + " does not exist.");
			return;
		}

		out.print("Person name (NULL for null, enter for no change, current - " + current.getName() + "): ");
		current.setName(this.convertString(scanner.nextLine(), current.getName()));

		out.print("Person surname (NULL for null, enter for no change, current - " + current.getSurname() + "): ");
		current.setSurname(this.convertString(scanner.nextLine(), current.getSurname()));

		out.print("Person address id (NULL for null, enter for no change, current - " + (current.getAddress() == null ? "NULL" : current.getAddress().getId()) + "): ");
		this.readAndSetAddress(scanner, current);
	}

	private void printAddress(StringBuilder sb, Address a) {
		sb.append("id = ").append(a.getId()).append(", streetName = ").append(a.getStreetName()).append(", houseNumber = ").append(a.getHouseNumber()).append(", flatNumber = ")
		.append(a.getFlatNumber()).append(", persons = (");

		Iterator<Person> iter = a.getPersons().iterator();
		while (iter.hasNext()) {
			Person p = iter.next();
			sb.append("<").append(p.getId()).append("> ").append(p.getName()).append(" ").append(p.getSurname());
			if (iter.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append(")");
	}

	@SuppressWarnings({ "unchecked" })
	private void printAddresses(StringBuilder sb) {
		List<Address> addresses = this.entityManager.createQuery("select a from Address a order by a.id").getResultList();

		sb.append("Addresses:\n");
		for (Address a : addresses) {
			//			try {
			//				Map<String,Object> properties = new HashMap();
			//				properties.put("javax.persistence.lock.timeout", 10000);
			//				this.entityManager.unwrap(Session.class).doWork(new Work() {
			//					@Override
			//					public void execute(Connection connection) throws SQLException {
			//						connection.createStatement().execute("set innodb_lock_wait_timeout = 1;");
			//					}
			//				});
			//								this.entityManager.lock(a, LockModeType.PESSIMISTIC_READ, properties);
			//				//				this.entityManager.lock(a, LockModeType.PESSIMISTIC_WRITE, properties);
			//			} catch (Exception lE) {
			//				System.out.println(lE);
			//			}
			this.printAddress(sb, a);
			sb.append("\n");
		}
	}

	private void printAddressHistory(StringBuilder sb, int addressId) {
		AuditReader reader = AuditReaderFactory.get(this.entityManager);

		List addressHistory = reader.createQuery().forRevisionsOfEntity(Address.class, false, true).add(AuditEntity.id().eq(addressId)).getResultList();

		if (addressHistory.size() == 0) {
			sb.append("A address with id ").append(addressId).append(" does not exist.\n");
		} else {
			for (Object historyObj : addressHistory) {
				Object[] history = (Object[]) historyObj;
				DefaultRevisionEntity revision = (DefaultRevisionEntity) history[1];
				sb.append("revision = ").append(revision.getId()).append(", ");
				this.printAddress(sb, (Address) history[0]);
				sb.append(" (").append(revision.getRevisionDate()).append(")\n");
			}
		}
	}

	private void printAddressAtRevision(StringBuilder sb, int addressId, int revision) {
		AuditReader reader = AuditReaderFactory.get(this.entityManager);

		Address a = reader.find(Address.class, addressId, revision);
		if (a == null) {
			sb.append("This address does not exist at that revision.");
		} else {
			this.printAddress(sb, a);
		}
	}

	private Address readNewAddress(PrintStream out, Scanner scanner) {
		Address a = new Address();

		out.print("Street name (NULL for null): ");
		a.setStreetName(this.convertString(scanner.nextLine(), ""));

		out.print("House number: ");
		a.setHouseNumber(this.convertStringToInteger(scanner.nextLine(), 0));

		out.print("Flat number: ");
		a.setFlatNumber(this.convertStringToInteger(scanner.nextLine(), 0));

		a.setPersons(new HashSet<Person>());

		return a;
	}

	private void readModifyAddress(PrintStream out, Scanner scanner, int addressId) {
		Address current = null;
		//		Map<String,Object> properties = new HashMap();
		//		properties.put("javax.persistence.lock.timeout", 10000);

		//		// Use Case 1: Read then lock
		//		// Lock after read, risk stale, could cause "OptimistickLockException"
		//		{
		//			current = this.entityManager.find(Address.class, addressId);
		//			this.entityManager.lock(current, LockModeType.PESSIMISTIC_WRITE, properties);
		//		}
		//
		// Use case 2: Read and lock
		// Locks LONGER, could cause bottlenecks, deadlock
		{
			current = this.entityManager.find(Address.class, addressId, LockModeType.PESSIMISTIC_WRITE);
		}
		//
		//		// Use case 3: Read then lock and refresh
		//		{
		//			current = this.entityManager.find(Address.class, addressId);
		//			// lock and refresh
		//			this.entityManager.refresh(current, LockModeType.PESSIMISTIC_WRITE);
		//		}

		if (current == null) {
			out.println("Address with id " + addressId + " does not exist.");
			return;
		}

		out.print("Street name (NULL for null, enter for no change, current - " + current.getStreetName() + "): ");
		current.setStreetName(this.convertString(scanner.nextLine(), current.getStreetName()));

		out.print("House number (enter for no change, current - " + current.getHouseNumber() + "): ");
		current.setHouseNumber(this.convertStringToInteger(scanner.nextLine(), current.getHouseNumber()));

		out.print("Flat number (enter for no change, current - " + current.getFlatNumber() + "): ");
		current.setFlatNumber(this.convertStringToInteger(scanner.nextLine(), current.getFlatNumber()));

	}

	private void start() {
		Scanner scanner = new Scanner(System.in);
		PrintStream out = System.out;

		while (true) {
			out.println("-----------------------------------------------");
			out.println("1 - list persons             5 - list addresses");
			out.println("2 - list person history      6 - list addresses history");
			out.println("3 - new person               7 - new address");
			out.println("4 - modify person            8 - modify address");
			out.println("9 - get person at revision  10 - get address at revision");
			out.println("                             0 - end");

			try {
				int choice = scanner.nextInt();

				scanner.nextLine();

				this.entityManager.getTransaction().begin();
				//				this.entityManager.unwrap(Session.class).doWork(new Work() {
				//					@Override
				//					public void execute(Connection connection) throws SQLException {
				//						connection.createStatement().execute("set innodb_lock_wait_timeout = 1;");
				//					}
				//				});

				StringBuilder sb;
				int personId;
				int addressId;
				int revision;
				switch (choice) {
				case 1:
					sb = new StringBuilder();
					this.printPersons(sb);
					out.println(sb.toString());
					break;
				case 2:
					out.print("Person id: ");
					personId = scanner.nextInt();
					scanner.nextLine();
					sb = new StringBuilder();
					this.printPersonHistory(sb, personId);
					out.println(sb.toString());
					break;
				case 3:
					Person p = this.readNewPerson(out, scanner);
					this.entityManager.persist(p);
					break;
				case 4:
					out.print("Person id: ");
					personId = scanner.nextInt();
					scanner.nextLine();
					this.readModifyPerson(out, scanner, personId);
					break;
				case 5:
					sb = new StringBuilder();
					this.printAddresses(sb);
					out.println(sb.toString());
					break;
				case 6:
					out.print("Address id: ");
					addressId = scanner.nextInt();
					scanner.nextLine();
					sb = new StringBuilder();
					this.printAddressHistory(sb, addressId);
					out.println(sb.toString());
					break;
				case 7:
					Address a = this.readNewAddress(out, scanner);
					this.entityManager.persist(a);
					break;
				case 8:
					out.print("Address id: ");
					addressId = scanner.nextInt();
					scanner.nextLine();
					this.readModifyAddress(out, scanner, addressId);
					break;
				case 9:
					out.print("Person id: ");
					personId = scanner.nextInt();
					scanner.nextLine();
					out.print("Revision number: ");
					revision = scanner.nextInt();
					scanner.nextLine();
					if (revision <= 0) {
						System.out.println("Revision must be greater then 0!");
						continue;
					}
					sb = new StringBuilder();
					this.printPersonAtRevision(sb, personId, revision);
					out.println(sb.toString());
					break;
				case 10:
					out.print("Address id: ");
					addressId = scanner.nextInt();
					scanner.nextLine();
					out.print("Revision number: ");
					revision = scanner.nextInt();
					scanner.nextLine();
					if (revision <= 0) {
						System.out.println("Revision must be greater then 0!");
						continue;
					}
					sb = new StringBuilder();
					this.printAddressAtRevision(sb, addressId, revision);
					out.println(sb.toString());
					break;

				case 0:
					return;
				}
			} catch (InputMismatchException e) {
				// continuing
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					//					Dsn40 dsn40 = new Dsn40();
					//					Dsn62 dsn62 = new Dsn62();
					//					dsn40.setIdContrat(1);
					//					dsn40.set_001("Test_1");
					//					dsn62.set_001("Test_1");
					//					dsn40.setFinContrat(dsn62);
					//					this.entityManager.persist(dsn40);
					this.entityManager.flush();
					this.entityManager.clear();
					this.entityManager.getTransaction().commit();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}

	private boolean hasData() {
		return (((Long) this.entityManager.createQuery("select count(a) from Address a").getSingleResult()) + ((Long) this.entityManager.createQuery("select count(p) from Person p").getSingleResult())) > 0;
	}

	private void populateTestData() {
		this.entityManager.getTransaction().begin();

		if (!this.hasData()) {
			Person p1 = new Person();
			Person p2 = new Person();
			Person p3 = new Person();

			Address a1 = new Address();
			Address a2 = new Address();

			p1.setName("James");
			p1.setSurname("Bond");
			p1.setAddress(a1);

			p2.setName("John");
			p2.setSurname("McClane");
			p2.setAddress(a2);

			p3.setName("Holly");
			p3.setSurname("Gennaro");
			p3.setAddress(a2);

			a1.setStreetName("MI6");
			a1.setHouseNumber(18);
			a1.setFlatNumber(25);
			a1.setPersons(new HashSet<Person>());
			a1.getPersons().add(p1);

			a2.setStreetName("Nakatomi Plaza");
			a2.setHouseNumber(10);
			a2.setFlatNumber(34);
			a2.setPersons(new HashSet<Person>());
			a2.getPersons().add(p2);
			a2.getPersons().add(p3);

			this.entityManager.persist(a1);
			this.entityManager.persist(a2);

			this.entityManager.persist(p1);
			this.entityManager.persist(p2);
			this.entityManager.persist(p3);

			System.out.println("The DB was populated with example data.");
		}
		this.entityManager.flush();
		this.entityManager.clear();
		this.entityManager.getTransaction().commit();
	}

	@MXBean
	public interface StatisticsMXBean extends Statistics {
	}

	public static void main(String[] args) throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, MalformedObjectNameException {
		Map<String, String> configurationOverrides = new HashMap<String, String>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolePU", configurationOverrides);
		EntityManager entityManager = emf.createEntityManager();

		// mise en place JMX
		SessionFactory sf = ((HibernateEntityManagerFactory)emf).getSessionFactory();

		//		ObjectName statsName = new ObjectName("org.hibernate:type=statistics");
		//		MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();
		//
		//		final Statistics statistics = sf.getStatistics();
		//		statistics.setStatisticsEnabled(true);
		//		Object statisticsMBean = Proxy.newProxyInstance(
		//				TestConsole.class.getClassLoader(), 
		//				new Class<?>[] { StatisticsMXBean.class }, 
		//				new InvocationHandler() {
		//					@Override
		//					public Object invoke(Object pProxy, Method pMethod, Object[] pArgs) throws Throwable {
		//						return pMethod.invoke(statistics, pArgs);
		//					}
		//				}
		//				);
		//		mbeanServer.registerMBean(statisticsMBean, statsName);



		StatisticsService statsMBean = new StatisticsService();
		statsMBean.setSessionFactory(sf);
		statsMBean.setStatisticsEnabled(true);

		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		mBeanServer.registerMBean(statsMBean, new ObjectName("Hibernate:application=Statistics"));

		// fin JMX


		TestConsole console = new TestConsole(entityManager);

		System.out.println("");
		System.out.println("Welcome to EntityVersions demo!");
		// If you would like to use HSQLDB, uncomment relevant entries in
		// hibernate-envers/src/demo/resources/META-INF/persistence.xml descriptor and add required JAR libraries.
		// String userDbFile = System.getProperty("java.io.tmpdir") + File.separator + "_versions_demo.db";
		// System.out.println("HSQLDB database file location: " + userDbFile);

		console.populateTestData();
		console.start();

		entityManager.close();
		emf.close();
	}
}
