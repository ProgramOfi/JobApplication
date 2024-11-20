package it.programmaCandidature.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import it.programmaCandidature.service.UtenteService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private UtenteService utenteService;
	
	public SecurityConfig(UtenteService utenteService) {
		this.utenteService = utenteService;
	}
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authz -> authz
				.requestMatchers("/login", "/register").permitAll() //permette l'accesso a tutti a login e register
				.anyRequest().authenticated() //richiede l'autenticazione per tutte le altre richieste
			)
			.formLogin(form -> form
				.loginPage("/login") //URL per il login
				.defaultSuccessUrl("/candidatura/lista", true) //URL che rimanda alla lista di candidature dell'utente dopo il login
				.failureUrl("/login?error=true") //URL che rimanda alla pagina di errore in caso di accesso errato
				.permitAll()
			)
			.logout(logout -> logout
				.logoutUrl("/logout") //URL di logout
				.logoutSuccessUrl("/login?logout") //URL che rimanda a login dopo il logout
				.permitAll()
			);
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); //codifica della password con BCrypt
	}
}
