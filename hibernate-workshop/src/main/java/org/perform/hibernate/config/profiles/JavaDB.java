package org.perform.hibernate.config.profiles;

import org.perform.hibernate.config.HibernateConfig;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Profile("javadb")
@Import(HibernateConfig.class)
@PropertySource(value = { "classpath:javadb.properties" })
public class JavaDB {
	
}
