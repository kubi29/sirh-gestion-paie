package dev.paie.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:cotisations-imposables.xml", "classpath:cotisations-non-imposables.xml","classpath:entreprise.xml", "classpath:grade.xml" })
public class JeuxDeDonneesConfig {

}
