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

@Controller //Definisce la classe come un controller Spring MVC, gestisce richieste HTTP e restituisce viste (file HTML o JSP)
@RequestMapping ("/candidatura") //I metodi di questa classe risponderanno a richieste il cui percorso inizia con /candidatura
public class CandidaturaController {
	
	@Autowired //inietta automaticamente una dipendenza nella classe (in questo caso CandidaturaRepository e UtenteRepository)
	private CandidaturaRepository repo;
	@Autowired
	private UtenteRepository utenteRepository;
	
	@GetMapping ("/lista")
	public String lista (Model model, Principal principal) { //metodo che mostra i dati del database tramite la classe Model
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
	
	/*@GetMapping ("/lista") //metodo che risponde alle richieste GET all'URL /candidatura/lista
	public String lista() {
		Iterable<Candidatura> candidatura = repo.findAll(); //Usa il respository (repo) per recuperare tutte le entita` Candidatura dal database
		
		candidatura.forEach((Candidatura c) -> {
			System.out.println(c.getId());
		}); 
		//Stampa a console l'id di ogni candidatura preso dalla lista 
		
		return "candidature"; //Restituisce candidature.ftl
	}
	
	/*@ResponseBody
	@GetMapping("/test")
	public String test() {
		return "Test sul controller.";
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}*/
}
