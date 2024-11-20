package it.programmaCandidature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.programmaCandidature.model.Utenti;

public interface UtenteRepository  extends JpaRepository<Utenti, Integer>{
	Utenti findByUsername(String username);
	Utenti findByEmail(String email);
}
