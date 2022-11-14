package org.nogin.database.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nogin.configuration.HibernateConfiguration;
import org.nogin.database.entity.News;
import org.nogin.database.entity.User;
import org.nogin.database.repository.NewsRepository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class NewsRepositoryImpl implements NewsRepository {
    private SessionFactory sessionFactory;

    public NewsRepositoryImpl() {
        this.sessionFactory = HibernateConfiguration.getSessionFactory();
    }

    @Override
    public List<News> findAll() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(News.class);
        Root<News> root = criteriaQuery.from(News.class);
        criteriaQuery.select(root);
        Query query = session.createQuery(criteriaQuery);
        List<News> newsList = query.getResultList();

        session.close();
        return newsList;
    }

    @Override
    public List<News> findAllByUser(User user) {
        return null;
    }

    @Override
    public News findById(Long id) {
        return null;
    }

    @Override
    public Optional<News> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public News createNews(News news) {
        return null;
    }

    @Override
    public News updateNewsTitle(News news, String title) {
        return null;
    }

    @Override
    public News updateNewsContent(News news, String content) {
        return null;
    }
}
