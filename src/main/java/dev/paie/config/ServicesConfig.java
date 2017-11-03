package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"dev.paie.service","dev.paie.entite","dev.paie.util","dev.paie.spring"})
@Import({JpaConfig.class, DataSourceMySQLConfig.class})
public class ServicesConfig {

}
