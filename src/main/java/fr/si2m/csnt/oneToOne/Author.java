package fr.si2m.csnt.oneToOne;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;

@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue
	private Integer		id;

	private String		name;

	@OneToOne(cascade = CascadeType.ALL)
	//	@PrimaryKeyJoinColumn
	private Biography	biography;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Biography getBiography() {
		return this.biography;
	}

	public void setBiography(Biography biography) {
		this.biography = biography;
	}

	public static void main(String[] args) {
		Map<String, String> configurationOverrides = new HashMap<String, String>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolePU", configurationOverrides);
		EntityManager entityManager = emf.createEntityManager();
		SessionFactory sessionFactory = ((HibernateEntityManagerFactory) emf).getSessionFactory();

		Session session = sessionFactory.openSession();  
		session.beginTransaction();  

		//		Author author = new Author();  
		//		author.setName("Jack London");  
		//
		//		session.persist(author);  
		//
		//		Biography biography = new Biography();  
		//		biography.setInformation("Jack London was an American author...");  
		//		biography.setAuthorId(author.getId());  
		//
		//		author.setBiography(biography);  

		Author author = new Author();
		author.setName(" O. Henry");

		Biography biography = new Biography();
		biography.setInformation("William Sydney Porter  better known as O. Henry...");

		author.setBiography(biography);
		biography.setAuthor(author);

		session.save(author);  

		session.getTransaction().commit();  

		session.close();  

	}  
}