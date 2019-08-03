package fr.scolarite.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Etudiant implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	@NotEmpty
	@Size(min=5,max=20)
	private String nom;
	
	@Email
	@NotEmpty
	private String email;
	
	//@NotEmpty
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateNaissance;
	private String photo;
	
	
	public Etudiant() {
		super();
	}


	public Etudiant(String nom, String email, Date dateNaissance, String photo) {
		super();
		this.nom = nom;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.photo = photo;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
}
