package org.nogin.newsportal;

import org.nogin.newsportal.database.repository.UserRepository;
import org.nogin.newsportal.database.repository.impl.UserRepositoryImpl;

public class DatabaseTestService {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
//        Session session = HibernateConfiguration.getSessionFactory().openSession();
//
//        session.beginTransaction();
//
//        User user = new User();
//        user.setLogin("user0");
//        user.setPassword("1111");
//
//        session.save(user);
//        session.getTransaction().commit();
//        HibernateConfiguration.shutdown();
        System.out.println(userRepository.findById(1l));
    }
}
