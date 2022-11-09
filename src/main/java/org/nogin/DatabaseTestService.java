package org.nogin;

import org.hibernate.Session;
import org.nogin.database.entity.User;
import org.nogin.configuration.HibernateConfiguration;

public class DatabaseTestService {
    public static void main(String[] args) {
        Session session = HibernateConfiguration.getSessionFactory().openSession();

        session.beginTransaction();

        User user = new User();
        user.setLogin("user0");
        user.setPassword("1111");

        session.save(user);
        session.getTransaction().commit();
        HibernateConfiguration.shutdown();
    }
}
