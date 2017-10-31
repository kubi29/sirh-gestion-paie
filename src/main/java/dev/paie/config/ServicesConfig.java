package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"dev.paie.service","dev.paie.entite","dev.paie.util"})
public class ServicesConfig {

}
