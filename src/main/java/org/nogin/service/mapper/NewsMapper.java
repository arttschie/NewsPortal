package org.nogin.service.mapper;

import org.nogin.service.models.News;

import java.util.List;

public interface NewsMapper {
    News mapToService(org.nogin.database.entity.News source);
    org.nogin.database.entity.News mapToDatabase(News source);
    List<News> mapToService(List<org.nogin.database.entity.News> source);
    List<org.nogin.database.entity.News> mapToDatabase(List<News> source);
}
