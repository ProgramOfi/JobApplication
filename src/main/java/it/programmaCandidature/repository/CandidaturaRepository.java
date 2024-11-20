package it.programmaCandidature.repository;

import org.springframework.data.repository.CrudRepository;

import it.programmaCandidature.model.Candidatura;
import it.programmaCandidature.model.Utenti;

public interface CandidaturaRepository extends CrudRepository<Candidatura,Integer> {
	
	Iterable<Candidatura> findByUtente(Utenti utente);
}
