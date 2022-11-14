package org.nogin.database.repository;

import org.nogin.database.entity.News;

import java.util.List;
import java.util.Optional;

public interface NewsRepository {
    List<News> findAll();
    List<News> findAllByUserId(Long userId);
    Optional<News> findById(Long id);
    Optional<News> findByTitle(String title);
    void createNews(News news);
    void updateNewsTitle(Long newsId, String title);
    void updateNewsContent(Long newsId, String content);
}
