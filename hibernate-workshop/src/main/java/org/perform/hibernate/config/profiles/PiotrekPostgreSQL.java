package org.perform.hibernate.config.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Profile("piotrek_psql")
@PropertySource({ "classpath:profiles/piotrek_psql.properties" })
public class PiotrekPostgreSQL {

}