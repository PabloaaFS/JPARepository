package com.futurespace.JPAProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DatabaseConfig {

    /**
     * Inyección de dependencia del entorno de Spring para acceder a las propiedades de la aplicación.
     */
    @Autowired
    Environment env;

    /**
     * Definición del DataSource para la conexión a la base de datos.
     * La configuración se lee del archivo application.properties (usando el objeto env).
     */
    @Bean
    public DataSource getDataSource() {
        //Constructor de DataSource
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username(env.getProperty("db.username"));
        dataSourceBuilder.password(env.getProperty("db.password"));
        dataSourceBuilder.url(env.getProperty("db.url"));
        return dataSourceBuilder.build();
    }

    /**
     * Crea y configura el EntityManagerFactory para gestionar las entidades de la base de datos.
     * Define el paquete base donde se escanearán las entidades.
     * Configura el proveedor JPA de Hibernate y las propiedades de Hibernate.
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(getDataSource());

        // Escaneo de clases anotadas con JPA.
        entityManagerFactory.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));

        // Adaptador de proveedor JPA de Hibernate
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

        // Configuracion Hibernate
        Properties additionalProperties = new Properties();
        additionalProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        additionalProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        additionalProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        entityManagerFactory.setJpaProperties(additionalProperties);

        return entityManagerFactory;
    }

    /**
     * Declaración del transaction manager.
     * Gestiona las transacciones JPA.
     */
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    /**
     * PersistenceExceptionTranslationPostProcessor es un postprocesador de bean que
     * añade un asesor a cualquier bean anotado con Repository para que cualquier excepción
     * específica de la plataforma sea capturada y luego rechazada como una de las excepciones
     * de acceso a datos no verificadas de Spring (es decir, una subclase de DataAccessException).
     */
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
