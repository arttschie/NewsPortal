package org.nogin.database.repository;

import org.nogin.database.entity.News;
import org.nogin.database.entity.User;

import java.util.List;
import java.util.Optional;

public interface NewsRepository {
    List<News> findAll();
    List<News> findAllByUser(User user);
    News findById(Long id);
    Optional<News> findByTitle(String title);
    News createNews(News news);
    News updateNewsTitle(News news, String title);
    News updateNewsContent(News news, String content);
}
