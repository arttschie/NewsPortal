package org.nogin.newsportal.service;

import org.nogin.newsportal.service.models.News;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    List<News> getNews();
    List<News> getNewsByUserId(Long userId);
    Optional<News> getById(Long id);
    Optional<News> getByTitle(String title);
    void createNews(News news);
    void changeNewsTitle(Long newsId, String title);
    void changeNewsContent(Long newsId, String content);
}
