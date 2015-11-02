package org.perform.hibernate.config;

import org.perform.hibernate.config.profiles.JavaDB;
import org.perform.hibernate.config.profiles.PostgreSQL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Import({ JavaDB.class, PostgreSQL.class })
@ComponentScan("org.perform.hibernate.dao")
public class ContextConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
