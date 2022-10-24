package org.nogin.service;

import org.hibernate.Session;
import org.nogin.models.User;
import org.nogin.repository.HibernateUtil;

public class DatabaseTestService {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        User user = new User();
        user.setLogin("user");
        user.setPassword("1111");

        session.save(user);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
