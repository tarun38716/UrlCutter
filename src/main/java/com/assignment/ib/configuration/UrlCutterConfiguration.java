package com.assignment.ib.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author Tarun
 *
 */
@Configuration
@ComponentScan(basePackages ="com.assignment.ib")
public class UrlCutterConfiguration {
	
	@Bean(name = "dataSource")
	public DataSource datasource(){
		EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = dbBuilder.setType(EmbeddedDatabaseType.H2).addScript("db/create-db.sql").build(); 
		return db;
	}
	
	
	

}
 