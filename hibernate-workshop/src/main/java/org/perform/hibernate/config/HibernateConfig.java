package org.perform.hibernate.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.perform.hibernate.config.profiles.JavaDB;
import org.perform.hibernate.config.profiles.PiotrekPostgreSQL;
import org.perform.hibernate.config.profiles.PostgreSQL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan("org.perform.hibernate.dao")
@Import({ JavaDB.class, PostgreSQL.class, PiotrekPostgreSQL.class })
public class HibernateConfig {

	@Value("${jdbc.driverClass}")
	private String jdbcDriverClass;
	@Value("${jdbc.url}")
	private String jdbcUrl;
	@Value("${jdbc.user}")
	private String jdbcUser;
	@Value("${jdbc.password}")
	private String jdbcPassword;

	@Resource
	private Environment environment;

	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(this.jdbcDriverClass);
		dataSource.setJdbcUrl(this.jdbcUrl);
		dataSource.setUser(this.jdbcUser);
		dataSource.setPassword(this.jdbcPassword);
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("org.perform.hibernate.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}

	@SuppressWarnings("serial")
	Properties hibernateProperties() {
		return new Properties() {
			{
				setProperty("hibernate.dialect");
				setProperty("hibernate.show_sql");
				setProperty("hibernate.format_sql");
				setProperty("hibernate.hbm2ddl.auto");
			}

			private void setProperty(String property) {
				setProperty(property, environment.getRequiredProperty(property));
			}
		};
	}
}
