package it.programmaCandidature.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Utenti {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idutenti;
	
	@Column(unique = true, name = "nome_utente")
	private String username;
	
	private String password;
	
	@Column(unique = true)
	private String email;
	
	@OneToOne(mappedBy="utente")
	private Candidatura candidatura;
	
	//Getters e Setters
	public Integer getIdUtenti() {
		return idutenti;
	}
	public void setIdUtenti(Integer idutenti) {
		this.idutenti = idutenti;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Candidatura getCandidature() {
        return candidatura;
	}
	public void setCandidature(Candidatura candidatura) {
	        this.candidatura = candidatura;
	}
}
