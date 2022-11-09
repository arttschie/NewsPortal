package org.nogin.database.repository;

import org.nogin.database.entity.News;
import org.nogin.database.entity.User;

import java.util.List;
import java.util.Optional;

public class NewsRepositoryImpl implements NewsRepository {
    @Override
    public List<News> findAll() {
        return null;
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
