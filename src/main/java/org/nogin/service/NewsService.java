package org.nogin.service;

import org.nogin.models.News;

import java.util.List;

//TODO CRUD
public interface NewsService {
    List<News> getNews();
    News findById(Long id);
    News findByTitle(String title);
}
