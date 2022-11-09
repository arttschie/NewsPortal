package org.nogin.mapper.impl;

import org.nogin.mapper.NewsMapper;
import org.nogin.models.News;
import org.nogin.models.User;
import org.nogin.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class NewsMapperImpl implements NewsMapper {
    @Override
    public News mapToService(org.nogin.entity.News source) {
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
    public org.nogin.entity.News mapToDatabase(News source) {
        return org.nogin.entity.News.builder()
                .id(source.getId())
                .title(source.getTitle())
                .content(source.getContent())
                .user(org.nogin.entity.User.builder()
                    .id(source.getUser().getId())
                    .login(source.getUser().getLogin())
                    .password(source.getUser().getPassword())
                    .build())
                .build();
    }

    @Override
    public List<News> mapToService(List<org.nogin.entity.News> source) {
        List<News> listNewsService = new ArrayList<>();
        for (org.nogin.entity.News news: source) {
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
    public List<org.nogin.entity.News> mapToDatabase(List<News> source) {
        List<org.nogin.entity.News> listNewsDatabase = new ArrayList<>();
        for (News news : source) {
            listNewsDatabase.add(org.nogin.entity.News.builder()
                                        .id(news.getId())
                                        .title(news.getTitle())
                                        .content(news.getContent())
                                        .user(org.nogin.entity.User.builder()
                                            .id(news.getUser().getId())
                                            .login(news.getUser().getLogin())
                                            .password(news.getUser().getPassword())
                                            .build())
                                        .build());
        }
        return listNewsDatabase;
    }
}
