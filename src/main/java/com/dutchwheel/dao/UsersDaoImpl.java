package com.dutchwheel.dao;

import com.dutchwheel.HibernateConnector;
import com.dutchwheel.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by antonkazakov on 04.12.16.
 */
public class UsersDaoImpl implements UsersDao{

    Session session;

    @Override
    public User getUserByToken(String apiKey) {

        this.session = HibernateConnector.getConnector().getSession();
        session.beginTransaction();

        List<User> result =  session.createQuery("from User where place = :paramName",User.class)
                .setParameter("paramName",apiKey)
                .list();

        session.getTransaction().commit();

        System.out.println(result.size());
        return result.get(0);
    }

    @Override
    public Integer signUp(String phone) {
        return null;
    }

}
