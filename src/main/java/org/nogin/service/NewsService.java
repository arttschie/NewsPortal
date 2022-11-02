package org.nogin.service;

import org.nogin.models.News;
import org.nogin.models.User;

import java.util.List;

//TODO CRUD
public interface NewsService {
    List<News> getNews();
    List<News> getNewsByUser(User user);
    News findById(Long id);
    News findByTitle(String title);
    void createNews(User user);
    News updateNewsTitle(News news, User user);
    News updateNewsContent(News news, User user);
}
