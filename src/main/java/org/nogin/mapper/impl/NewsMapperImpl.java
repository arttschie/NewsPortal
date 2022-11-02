package org.nogin.mapper.impl;

import org.nogin.mapper.NewsMapper;
import org.nogin.models.News;
import org.nogin.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NewsMapperImpl implements NewsMapper {
    @Override
    public News mapToService(org.nogin.entity.News source) {
        return new News().builder()
                .id(source.getId())
                .title(source.getTitle())
                .content(source.getContent())
                .user(new User.builder()
                        .id(source.getUser().getId())
                        .login(source.getUser().getLogin())
                        .password(source.getUser().getPassword())
                        .build())
                .build();
    }

    @Override
    public org.nogin.entity.News mapToDatabase(News source) {
        return new org.nogin.entity.News().builder()
                .id(source.getId())
                .title(source.getTitle())
                .content(source.getContent())
                .user(new org.nogin.entity.User.builder()
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
            listNewsService.add(new News().builder()
                                        .id(source.getId())
                                        .title(source.getTitle())
                                        .content(source.getContent())
                                        .user(User.builder()
                                            .id(source.getUser().getId())
                                            .login(source.getUser().getLogin())
                                            .password(source.getUser().getPassword())
                                            .build())
                                        .build());
        }
        return listNewsService;
    }

    @Override
    public List<org.nogin.entity.News> mapToDatabase(List<News> source) {
        List<org.nogin.entity.News> listNewsDatabase = new ArrayList<>();
        for (News news : source) {
            listNewsDatabase.add(new org.nogin.entity.News().builder()
                                        .id(source.getId())
                                        .title(source.getTitle())
                                        .content(source.getContent())
                                        .user(new org.nogin.entity.User.builder()
                                            .id(source.getUser().getId())
                                            .login(source.getUser().getLogin())
                                            .password(source.getUser().getPassword())
                                            .build())
                                        .build());
        }
        return listNewsDatabase;
    }
}
