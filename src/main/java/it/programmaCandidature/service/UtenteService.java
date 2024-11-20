package it.programmaCandidature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.programmaCandidature.model.Utenti;
import it.programmaCandidature.repository.UtenteRepository;

@Service
public class UtenteService implements UserDetailsService {
	
	private UtenteRepository utenteRepository;
	
	public UtenteService (UtenteRepository utenteRepository) {
		this.utenteRepository = utenteRepository;
	}

	//ricerca dell'utente tramite username e assegnazione del ruolo
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utenti utente = utenteRepository.findByUsername(username);
		if (utente == null) {
			throw new UsernameNotFoundException("Utente non trovato");
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<>(); 
		authorities.add(new SimpleGrantedAuthority("ROLE_USER")); 
		return new User(utente.getUsername(), utente.getPassword(), authorities);
	}
}
