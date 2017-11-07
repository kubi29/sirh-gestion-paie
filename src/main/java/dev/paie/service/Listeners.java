package dev.paie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
class Listeners {

	@Autowired
	private InitialiserDonneesService initialiserDonnees;


	@EventListener({ ContextRefreshedEvent.class })
	void contextRefreshedEvent() {

		initialiserDonnees.initialiser();

	}
}
