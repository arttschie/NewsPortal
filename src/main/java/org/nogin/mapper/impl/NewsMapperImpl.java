package org.nogin.mapper.impl;

import org.nogin.mapper.NewsMapper;
import org.nogin.models.News;

import java.util.List;

public class NewsMapperImpl implements NewsMapper {
    @Override
    public News mapToService(org.nogin.entity.News source) {
        return new News().builder()
                .id(source.getId())
                .title(source.getTitle())
                .content(source.getContent())
                .build();
    }

    @Override
    public org.nogin.entity.News mapToDatabase(News source) {
        return null;
    }

    @Override
    public List<News> mapToService(List<org.nogin.entity.News> source) {
        return null;
    }

    @Override
    public List<org.nogin.entity.News> mapToDatabase(List<News> source) {
        return null;
    }
}
