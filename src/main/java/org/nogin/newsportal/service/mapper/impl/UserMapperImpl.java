package org.nogin.newsportal.service.mapper.impl;

import org.nogin.newsportal.service.models.User;
import org.nogin.newsportal.service.mapper.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapperImpl implements UserMapper {

    @Override
    public User mapToService(org.nogin.newsportal.database.entity.User source) {
        if (source == null) {
            return null;
        }

        return User.builder()
                .id(source.getId())
                .login(source.getLogin())
                .password(source.getPassword())
                .build();
    }

    @Override
    public org.nogin.newsportal.database.entity.User mapToDatabase(User source) {
        if (source == null) {
            return null;
        }
        
        return org.nogin.newsportal.database.entity.User.builder()
                .id(source.getId())
                .login(source.getLogin())
                .password(source.getPassword())
                .build();
    }

    @Override
    public List<User> mapToService(List<org.nogin.newsportal.database.entity.User> source) {
        return source.stream().map(this::mapToService).collect(Collectors.toList());
    }

    @Override
    public List<org.nogin.newsportal.database.entity.User> mapToDatabase(List<User> source) {
        return source.stream().map(this::mapToDatabase).collect(Collectors.toList());
    }
}
