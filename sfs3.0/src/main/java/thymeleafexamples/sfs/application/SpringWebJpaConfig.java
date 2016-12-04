package thymeleafexamples.sfs.application;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.google.common.base.Preconditions;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableTransactionManagement
@PropertySource({ "classpath:persistence-mysql.properties" })
public class SpringWebJpaConfig {
  @Autowired
  private Environment env;

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource) {
      final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(dataSource);
      em.setPackagesToScan(new String[] { "thymeleafexamples.sfs.business.entities" });

      final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      em.setJpaVendorAdapter(vendorAdapter);
      em.setJpaProperties(additionalProperties());

      return em;
  }

  @Bean
  public DataSource dataSource() {
      final BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty("jdbc.driverClassName")));
      dataSource.setUrl(Preconditions.checkNotNull(env.getProperty("jdbc.url")));
      dataSource.setUsername(Preconditions.checkNotNull(env.getProperty("jdbc.user")));
      dataSource.setPassword(Preconditions.checkNotNull(env.getProperty("jdbc.pass")));

      return dataSource;
  }

  @Bean
  public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
      final JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(emf);
      return transactionManager;
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
      return new PersistenceExceptionTranslationPostProcessor();
  }

  final Properties additionalProperties() {
      final Properties hibernateProperties = new Properties();
      hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
      hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
      // hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", "true");
      return hibernateProperties;
  }
}
