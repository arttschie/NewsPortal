package org.nogin.database.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nogin.configuration.HibernateConfiguration;
import org.nogin.database.entity.News;
import org.nogin.database.entity.User;
import org.nogin.database.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private SessionFactory sessionFactory;

    public UserRepositoryImpl() {
        this.sessionFactory = HibernateConfiguration.getSessionFactory();
    }

    @Override
    public List<User> findAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> root = criteriaQuery.from(User.class);
            criteriaQuery.select(root);

            Query query = session.createQuery(criteriaQuery);
            List<User> userList = query.getResultList();

            return userList;
        }
    }

    @Override
    public Optional<User> findUserByNewsId(Long newsId) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<News> root = criteriaQuery.from(User.class);
            criteriaQuery.select(root);
            criteriaQuery.where(criteriaBuilder.equal(root.get("id"), newsId));

            Query query = session.createQuery(criteriaQuery);
            User user = (User) query.getSingleResult();

            return Optional.of(user);
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.of(session.get(User.class, id));
        }
    }

    @Override
    public Optional<User> findByLogin(String login) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<News> root = criteriaQuery.from(User.class);
            criteriaQuery.select(root);
            criteriaQuery.where(criteriaBuilder.equal(root.get("login"), login));

            Query query = session.createQuery(criteriaQuery);
            User user = (User) query.getSingleResult();

            return Optional.of(user);
        }
    }

    @Override
    public Optional<User> findByPassword(String password) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<News> root = criteriaQuery.from(User.class);
            criteriaQuery.select(root);
            criteriaQuery.where(criteriaBuilder.equal(root.get("password"), password));

            Query query = session.createQuery(criteriaQuery);
            User user = (User) query.getSingleResult();

            return Optional.of(user);
        }
    }

    @Override
    public void createUser(User user) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void updateUserLogin(Long userId, String login) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, userId);
            user.setLogin(login);
            session.update(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void updateUserPassword(Long userId, String password) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, userId);
            user.setPassword(password);
            session.update(user);
            session.getTransaction().commit();
        }
    }
}
