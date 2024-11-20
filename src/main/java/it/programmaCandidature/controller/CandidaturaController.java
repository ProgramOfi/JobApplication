package it.programmaCandidature.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import it.programmaCandidature.model.Candidatura;
import it.programmaCandidature.model.Utenti;
import it.programmaCandidature.repository.CandidaturaRepository;
import it.programmaCandidature.repository.UtenteRepository;

@Controller 
@RequestMapping ("/candidatura") 
public class CandidaturaController {
	
	@Autowired 
	private CandidaturaRepository repo;
	@Autowired
	private UtenteRepository utenteRepository;
	
	//cerca l'utente e carica la sua pagina di candidature
	@GetMapping ("/lista")
	public String lista (Model model, Principal principal) { 
		String username = principal.getName();
		Utenti utente = utenteRepository.findByUsername(username);
		Iterable<Candidatura> candidatura = repo.findByUtente(utente);
		candidatura.forEach((Candidatura c) -> {
			if (c.getNote() == null) {
				c.setNote("Nessuna nota");
			}
		}); 
		model.addAttribute ("candidature", candidatura);
		return "candidature";
	}
}
