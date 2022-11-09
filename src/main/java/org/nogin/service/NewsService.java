package org.nogin.service;

import org.nogin.service.models.News;
import org.nogin.service.models.User;

import java.util.List;

public interface NewsService {
    List<News> getNews();
    List<News> getNewsByUser(User user);
    News getById(Long id);
    News getByTitle(String title);
    News createNews(News news);
    News changeNewsTitle(News news, String title);
    News changeNewsContent(News news, String content);
}
