package fr.si2m.csnt.oneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity  
@Table(name="biographies")  
public class Biography {  

	@Id  
	@Column(name="author_id")

	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign",
	parameters=@Parameter(name="property", value="author"))
	private Integer authorId;

	private String information;

	@OneToOne  
	@PrimaryKeyJoinColumn
	private Author author;  

	public Author getAuthor() {  
		return this.author;  
	}  

	public void setAuthor(Author author) {  
		this.author = author;  
	}  
	public Integer getAuthorId() {
		return this.authorId;
	}  

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}  

	public String getInformation() {
		return this.information;
	}  

	public void setInformation(String information) {
		this.information = information;
	}  

}  