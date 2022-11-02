package org.nogin.service;

import org.nogin.models.News;
import org.nogin.models.User;

import java.util.List;

//TODO CRUD
public interface NewsService {
    List<News> getNews();
    List<News> getNewsByUser(User user);
    News getById(Long id);
    News getByTitle(String title);
    void createNews(User user);
    News changeNewsTitle(News news, User user);
    News changeNewsContent(News news, User user);
}
