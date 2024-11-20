package it.programmaCandidature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import it.programmaCandidature.model.Utenti;
import it.programmaCandidature.repository.UtenteRepository;

@Controller
public class RegisterController {
	
	private UtenteRepository utenteRepository;
	private PasswordEncoder passwordEncoder;
	
	public RegisterController(UtenteRepository utenteRepository, PasswordEncoder passwordEncoder) {
		this.utenteRepository = utenteRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@GetMapping("/register")
	public String formRegistrazione() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registraUtente(String username, String email, String password, Model model) {
		//controlla se l'username esiste gia`
		if (utenteRepository.findByUsername(username) != null) {
			model.addAttribute("error", "Username gia` in uso, scegline un altro");
			return "register";
		}
		//controlla se la mail esiste gia`
		if (utenteRepository.findByEmail(email) != null) {
			model.addAttribute("error", "Email gia` in uso, scegline un'altra");
			return "register";
		}
		//crea il nuovo utente passando i parametri
		Utenti nuovoUtente = new Utenti();
		nuovoUtente.setUsername(username);
		nuovoUtente.setEmail(email);
		nuovoUtente.setPassword(passwordEncoder.encode(password));
		//salva il nuovo utente nel database
		utenteRepository.save(nuovoUtente);
		//reindirizza al login
		return "redirect:/login";
	}
}
