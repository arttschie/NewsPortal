package org.nogin.service.mapper.impl;

import org.nogin.service.mapper.NewsMapper;
import org.nogin.service.models.News;
import org.nogin.service.models.User;

import java.util.List;
import java.util.stream.Collectors;

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
        if (source == null) {
            return null;
        }

        org.nogin.database.entity.User user = null;
        
        if (source.getUser() != null) {
            user = org.nogin.database.entity.User.builder()
                    .id(source.getUser().getId())
                    .login(source.getUser().getLogin())
                    .password(source.getUser().getPassword())
                    .build();
        }
        
        return org.nogin.database.entity.News.builder()
                .id(source.getId())
                .title(source.getTitle())
                .content(source.getContent())
                .user(user)
                .build();
    }

    @Override
    public List<News> mapToService(List<org.nogin.database.entity.News> source) {
        return source.stream().map(this::mapToService).collect(Collectors.toList());
    }

    @Override
    public List<org.nogin.database.entity.News> mapToDatabase(List<News> source) {
        return source.stream().map(this::mapToDatabase).collect(Collectors.toList());
    }
}
