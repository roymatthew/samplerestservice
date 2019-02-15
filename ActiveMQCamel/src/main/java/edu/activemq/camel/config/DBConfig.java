package edu.activemq.camel.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {
	
	@Bean(name="datasource")
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource()
	{
		DataSource ds = DataSourceBuilder.create().build();
		return ds;
	}

}
