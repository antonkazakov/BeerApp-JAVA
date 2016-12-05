package com.dutchwheel;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by antonkazakov on 04.12.16.
 */
public class HibernateConnector {

    private static HibernateConnector connector;
    private Configuration configuration;
    private SessionFactory sessionFactory;

    static {
        connector = new HibernateConnector();
    }

    private HibernateConnector() {
        configuration = new Configuration();

        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://188.166.51.35:5432/testdb");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.username", "javauser");
        configuration.setProperty("hibernate.connection.password", "23850");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");


        configuration.addAnnotatedClass(User.class);

        sessionFactory = configuration.buildSessionFactory();
    }


    public static HibernateConnector getConnector() {
        return connector;
    }

    public Session getSession() throws HibernateException {
        Session session = sessionFactory.openSession();
        if (!session.isConnected()) {
            this.reconnect();
        }
        return session;
    }

    private void reconnect() throws HibernateException {
        this.sessionFactory = configuration.buildSessionFactory();
    }

}
