package com.ailmax.backend.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.ailmax.backend" })
public class HibernateConfiguration {
//this part taught by pankaj sir
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean bean=new LocalSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPackagesToScan(new String[] { "com.ailmax.backend.model"});
		bean.setHibernateProperties(hibernateProperties());
		return bean;
		
	}
public Properties hibernateProperties() {
	Properties p=new Properties();
	p.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	p.put("hibernate.show_sql", true);
	p.put("hibernate.format_sql", true);
	p.put("hibernate.hbm2ddl.auto", "update");
		return p;
	}
@Bean
	public DataSource dataSource() {
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	dataSource.setUrl("jdbc:mysql://localhost:3306/shopbase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
	dataSource.setUsername("root");
	dataSource.setPassword("");
	return dataSource;
	}
@Bean
@Autowired
public HibernateTransactionManager transactionManager(SessionFactory s) {
	HibernateTransactionManager txManager = new HibernateTransactionManager();
	txManager.setSessionFactory(s);
	return txManager;
}
	
}
