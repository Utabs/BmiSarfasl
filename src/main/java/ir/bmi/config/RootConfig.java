package ir.bmi.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import ir.bmi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
/**
 * Created by utab on 7/6/2016.
 */
@Configuration
 public class RootConfig {
 private static final String HIBERNATE_ENTITYMANAGER_PACKAGES_TO_SCAN = "ir.bmi";
 private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
 private static final String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
 private static final String HIBERNATE_SHOW_SQL_VALUE = "true";
 private static final String HIBERNATE_SQL_FORMAT_VALUE = "true";

 private static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
 private static final String HIBERNATE_HBM2DDL_AUTO_VALUE = "create-drop";

 private static final String HIBERNATE_DTIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
 private static final String HIBERNATE_JDBC_URL = "jdbc:oracle:thin:@//localhost:1521/orcl";

 private static final String HIBERNATE_DIALECT = "hibernate.dialect";
 private static final String HIBERNATE_DIALECT_VALUE = "org.hibernate.dialect.Oracle10gDialect";


// private static final String HIBERNATE_MAX_FETCH_DEPTH = "hibernate.max_fetch_depth";
// private static final String HIBERNATE_JDBC_FETCH_SIZE = "hibernate.jdbc.fetch_size";
// private static final String HIBERNATE_JDBC_BATCH_SIZE = "hibernate.jdbc.batch_size";

 private static final Integer HIBERNATE_MAX_POOL_SIZE = 10;
 private static final Integer HIBERNATE_MAX_STATEMENTS = 0;
 private static final Integer HIBERNATE_MIN_POOL_SIZE = 5;

 private static final String HIBERNATE_USER = "test";
 private static final String HIBERNATE_PASSWORD = "test";

 //@Autowired
// private Environment environment;

 private Properties jpaHibernateProperties() {
  Properties properties = new Properties();
  properties.put(HIBERNATE_SHOW_SQL, HIBERNATE_SHOW_SQL_VALUE);
  properties.put(HIBERNATE_FORMAT_SQL, HIBERNATE_SQL_FORMAT_VALUE);

  properties.put(HIBERNATE_DIALECT, HIBERNATE_DIALECT_VALUE);
  properties.put(HIBERNATE_HBM2DDL_AUTO, HIBERNATE_HBM2DDL_AUTO_VALUE);
//  properties.put("hibernate.connection.autocommit", "true");
  return properties;
 }


 @Bean(name = "datasource", destroyMethod = "close")
 ComboPooledDataSource dataSource() {
  try {
   ComboPooledDataSource dataSource = new ComboPooledDataSource();
   dataSource.setDriverClass(HIBERNATE_DTIVER_CLASS);
   dataSource.setJdbcUrl(HIBERNATE_JDBC_URL);
   dataSource.setUser(HIBERNATE_USER);
   dataSource.setPassword(HIBERNATE_PASSWORD);
   dataSource.setMaxPoolSize(HIBERNATE_MAX_POOL_SIZE);
   dataSource.setMaxStatements(HIBERNATE_MAX_STATEMENTS);
   dataSource.setMinPoolSize(HIBERNATE_MIN_POOL_SIZE);
   System.out.println("1- Data source bean...");
   return dataSource;
  } catch (PropertyVetoException ex) {
   ex.printStackTrace();
   return null;
  }
 }

 @Bean
 public JpaTransactionManager jpaTransactionManager() {
  JpaTransactionManager transactionManager = new JpaTransactionManager();
  transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
  System.out.println("2- Jpa Transaction Manager");
  return transactionManager;
 }

 @Bean
 public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
  LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
  entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
  entityManagerFactoryBean.setDataSource(dataSource());
  entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
  entityManagerFactoryBean.setPackagesToScan(HIBERNATE_ENTITYMANAGER_PACKAGES_TO_SCAN);
  entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());
  System.out.println("3- Entity Manager Factory Bean ...");
  return entityManagerFactoryBean;
 }

 private HibernateJpaVendorAdapter vendorAdaptor() {
  HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
  vendorAdapter.setShowSql(true);
  System.out.println("4- Vendor Adapter ...");
  return vendorAdapter;
 }

}
