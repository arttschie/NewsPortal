package org.nogin.database.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nogin.configuration.HibernateConfiguration;
import org.nogin.database.entity.News;
import org.nogin.database.entity.User;
import org.nogin.database.repository.UserRepository;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private SessionFactory sessionFactory;

    public UserRepositoryImpl() {
        this.sessionFactory = HibernateConfiguration.getSessionFactory();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findUserByNews(News news) {
        return null;
    }

    @Override
    public User findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, 1L);
        }
    }

    @Override
    public User findByLogin(String login) {
        return null;
    }

    @Override
    public User findByPassword(String password) {
        return null;
    }

    @Override
    public void insertUser() {

    }

    @Override
    public User updateUserLogin(User user, String login) {
        return null;
    }

    @Override
    public User updateUserPassword(User user, String password) {
        return null;
    }
}
