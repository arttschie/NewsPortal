package org.nogin;

import org.hibernate.Session;
import org.nogin.database.entity.User;
import org.nogin.configuration.HibernateConfiguration;
import org.nogin.database.repository.UserRepository;
import org.nogin.database.repository.impl.UserRepositoryImpl;
import org.nogin.service.UserService;
import org.nogin.service.impl.UserServiceImpl;

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
