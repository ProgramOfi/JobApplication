package it.programmaCandidature.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Candidatura {
	
	@Id
	@Column(name="id_idutente")
	private Integer id_idutente;
	
	@Column(name="nome_azienda") //accede alla colonna del database che si chiama "nome_azienda"
	private String azienda; //crea un attributo da utilizzare nelle altre classi o file, collegato alla colonna "nome_azienda"
	
	//@Column(name="posizione")
	private String posizione; //in questo modo accede direttamente alla colonna e crea un attributo con lo stesso nome
	
	@Column(name="data_applicazione")
	private String dataApplicazione;
	
	@Column(name="note")
	private String note;

	@OneToOne
	@MapsId
    @JoinColumn(name = "id_idutenti")
	private Utenti utente;
	
//Getters e Setters
	public Integer getId_idutenti() {
		return id_idutente;
	}
	public String getAzienda() {
		return azienda;
	}
	public String getPosizione() {
		return posizione;
	}
	public String getDataApplicazione() {
		return dataApplicazione;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Utenti getUtente() {
		return utente;
	}
}
