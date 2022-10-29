package org.nogin.mapper;

import org.nogin.models.News;

import java.util.List;

public interface NewsMapper {
    News mapToService(org.nogin.entity.News source);
    org.nogin.entity.News mapToDatabase(News source);
    List<News> mapToService(List<org.nogin.entity.News> source);
    List<org.nogin.entity.News> mapToDatabase(List<News> source);
}
