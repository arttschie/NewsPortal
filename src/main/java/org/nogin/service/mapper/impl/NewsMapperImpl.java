package org.nogin.service.mapper.impl;

import org.nogin.service.mapper.NewsMapper;
import org.nogin.service.models.News;
import org.nogin.service.models.User;

import java.util.ArrayList;
import java.util.List;

public class NewsMapperImpl implements NewsMapper {
    @Override
    public News mapToService(org.nogin.database.entity.News source) {
        if (source == null) {
            return null;
        }

        User user = null;

        if(source.getUser() != null) {
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
    public org.nogin.database.entity.News mapToDatabase(News source) {
        return org.nogin.database.entity.News.builder()
                .id(source.getId())
                .title(source.getTitle())
                .content(source.getContent())
                .user(org.nogin.database.entity.User.builder()
                    .id(source.getUser().getId())
                    .login(source.getUser().getLogin())
                    .password(source.getUser().getPassword())
                    .build())
                .build();
    }

    @Override
    public List<News> mapToService(List<org.nogin.database.entity.News> source) {
        List<News> listNewsService = new ArrayList<>();
        for (org.nogin.database.entity.News news: source) {
            listNewsService.add(News.builder()
                                    .id(news.getId())
                                    .title(news.getTitle())
                                    .content(news.getContent())
                                    .user(User.builder()
                                        .id(news.getUser().getId())
                                        .login(news.getUser().getLogin())
                                        .password(news.getUser().getPassword())
                                        .build())
                                    .build());
        }
        return listNewsService;
    }

    @Override
    public List<org.nogin.database.entity.News> mapToDatabase(List<News> source) {
        List<org.nogin.database.entity.News> listNewsDatabase = new ArrayList<>();
        for (News news : source) {
            listNewsDatabase.add(org.nogin.database.entity.News.builder()
                                        .id(news.getId())
                                        .title(news.getTitle())
                                        .content(news.getContent())
                                        .user(org.nogin.database.entity.User.builder()
                                            .id(news.getUser().getId())
                                            .login(news.getUser().getLogin())
                                            .password(news.getUser().getPassword())
                                            .build())
                                        .build());
        }
        return listNewsDatabase;
    }
}
