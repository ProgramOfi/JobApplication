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

	//controllo degli accessi alle pagine
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authz -> authz
				.requestMatchers("/login", "/register").permitAll()
				.anyRequest().authenticated() 
			)
			.formLogin(form -> form
				.loginPage("/login") 
				.defaultSuccessUrl("/candidatura/lista", true) 
				.failureUrl("/login?error=true") 
				.permitAll()
			)
			.logout(logout -> logout
				.logoutUrl("/logout") 
				.logoutSuccessUrl("/login?logout") 
				.permitAll()
			);
		return http.build();
	}

	//codifica della password
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
