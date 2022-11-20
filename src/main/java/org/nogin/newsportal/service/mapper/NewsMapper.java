package org.nogin.newsportal.service.mapper;

import org.nogin.newsportal.database.entity.News;

import java.util.List;

public interface NewsMapper {
    org.nogin.newsportal.service.models.News mapToService(News source);
    News mapToDatabase(org.nogin.newsportal.service.models.News source);
    List<org.nogin.newsportal.service.models.News> mapToService(List<News> source);
    List<News> mapToDatabase(List<org.nogin.newsportal.service.models.News> source);
}
