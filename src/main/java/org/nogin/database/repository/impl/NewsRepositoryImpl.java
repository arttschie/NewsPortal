package org.nogin.database.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nogin.configuration.HibernateConfiguration;
import org.nogin.database.entity.News;
import org.nogin.database.repository.NewsRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public class NewsRepositoryImpl implements NewsRepository {
    private SessionFactory sessionFactory;

    public NewsRepositoryImpl() {
        this.sessionFactory = HibernateConfiguration.getSessionFactory();
    }

    @Override
    public List<News> findAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(News.class);
            Root<News> root = criteriaQuery.from(News.class);
            criteriaQuery.select(root);

            Query query = session.createQuery(criteriaQuery);
            List<News> newsList = query.getResultList();

            return newsList;
        }
    }

    @Override
    public List<News> findAllByUserId(Long userId) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(News.class);
            Root<News> root = criteriaQuery.from(News.class);
            criteriaQuery.select(root);
            criteriaQuery.where(criteriaBuilder.equal(root.get("id"), userId));

            Query query = session.createQuery(criteriaQuery);
            List<News> newsList = query.getResultList();

            return newsList;
        }
    }

    @Override
    public Optional<News> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.of(session.get(News.class, id));
        }
    }

    @Override
    public Optional<News> findByTitle(String title) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(News.class);
            Root<News> root = criteriaQuery.from(News.class);
            criteriaQuery.select(root);
            criteriaQuery.where(criteriaBuilder.equal(root.get("title"), title));

            Query query = session.createQuery(criteriaQuery);
            News news = (News) query.getSingleResult();

            return Optional.of(news);
        }
    }

    @Override
    public void createNews(News news) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(news);
            session.getTransaction().commit();
        }
    }

    @Override
    public void updateNewsTitle(Long newsId, String title) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            News news = session.get(News.class, newsId);
            news.setTitle(title);
            session.update(news);
            session.getTransaction().commit();
        }
    }

    @Override
    public void updateNewsContent(Long newsId, String content) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            News news = session.get(News.class, newsId);
            news.setContent(content);
            session.update(news);
            session.getTransaction().commit();
        }
    }
}
