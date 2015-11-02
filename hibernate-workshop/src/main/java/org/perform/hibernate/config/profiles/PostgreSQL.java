package org.perform.hibernate.config.profiles;

import org.springframework.context.annotation.Profile;

@Profile("postgresql")
public class PostgreSQL {
	static {
		System.out.println("postgresql");
	}
}
