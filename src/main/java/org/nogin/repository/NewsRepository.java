package org.nogin.repository;

import org.nogin.entity.News;
import org.nogin.entity.User;

import java.util.List;
import java.util.Optional;

public interface NewsRepository {
    List<News> findAll();
    List<News> findAllByUser(User user);
    News findById(Long id);
    Optional<News> findByTitle(String title);
    void insertNews(User user);
    News updateNewsTitle(News news, String title);
    News updateNewsContent(News news, String content);
}
