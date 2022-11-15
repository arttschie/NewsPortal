package org.nogin.service.mapper.impl;

import org.nogin.service.mapper.UserMapper;
import org.nogin.service.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapperImpl implements UserMapper {

    @Override
    public User mapToService(org.nogin.database.entity.User source) {
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
    public org.nogin.database.entity.User mapToDatabase(User source) {
        if (source == null) {
            return null;
        }
        
        return org.nogin.database.entity.User.builder()
                .id(source.getId())
                .login(source.getLogin())
                .password(source.getPassword())
                .build();
    }

    @Override
    public List<User> mapToService(List<org.nogin.database.entity.User> source) {
        return source.stream().map(this::mapToService).collect(Collectors.toList());
    }

    @Override
    public List<org.nogin.database.entity.User> mapToDatabase(List<User> source) {
        return source.stream().map(this::mapToDatabase).collect(Collectors.toList());
    }
}
