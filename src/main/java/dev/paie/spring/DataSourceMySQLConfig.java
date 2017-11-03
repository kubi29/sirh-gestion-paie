package dev.paie.spring;

import javax.sql.DataSource;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan({"dev.paie.service","dev.paie.util"})
public class DataSourceMySQLConfig {

	
	@Bean
	public DataSource dataSource() {
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	dataSource.setUrl("jdbc:mysql://localhost:3306/sirh-paie?useSSL=false");
	dataSource.setUsername("root");
	dataSource.setPassword("");
	return dataSource;
	}
	
}
