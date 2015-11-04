package org.perform.hibernate.config.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Profile("postgresql")
@PropertySource({ "classpath:postgresql.properties" })
public class PostgreSQL {

}