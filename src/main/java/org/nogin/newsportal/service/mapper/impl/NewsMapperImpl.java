package org.nogin.newsportal.service.mapper.impl;

import org.nogin.newsportal.database.entity.News;
import org.nogin.newsportal.database.entity.User;
import org.nogin.newsportal.service.mapper.NewsMapper;

import java.util.List;
import java.util.stream.Collectors;

public class NewsMapperImpl implements NewsMapper {
    @Override
    public org.nogin.newsportal.service.models.News mapToService(News source) {
        if (source == null) {
            return null;
        }

        org.nogin.newsportal.service.models.User user = null;

        if(source.getUser() != null) {
            user = org.nogin.newsportal.service.models.User.builder()
                    .id(source.getUser().getId())
                    .login(source.getUser().getLogin())
                    .password(source.getUser().getPassword())
                    .build();
        }

        return org.nogin.newsportal.service.models.News.builder()
                .id(source.getId())
                .title(source.getTitle())
                .content(source.getContent())
                .user(user)
                .build();
    }

    @Override
    public News mapToDatabase(org.nogin.newsportal.service.models.News source) {
        if (source == null) {
            return null;
        }

        User user = null;
        
        if (source.getUser() != null) {
            user = User.builder()
                    .id(source.getUser().getId())
                    .login(source.getUser().getLogin())
                    .password(source.getUser().getPassword())
                    .build();
        }
        
        return News.builder()
                .id(source.getId())
                .title(source.getTitle())
                .content(source.getContent())
                .user(user)
                .build();
    }

    @Override
    public List<org.nogin.newsportal.service.models.News> mapToService(List<News> source) {
        return source.stream().map(this::mapToService).collect(Collectors.toList());
    }

    @Override
    public List<News> mapToDatabase(List<org.nogin.newsportal.service.models.News> source) {
        return source.stream().map(this::mapToDatabase).collect(Collectors.toList());
    }
}
