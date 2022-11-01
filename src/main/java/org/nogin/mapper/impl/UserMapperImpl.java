package org.nogin.mapper.impl;

import org.nogin.mapper.NewsMapper;
import org.nogin.mapper.UserMapper;
import org.nogin.models.News;
import org.nogin.models.User;

import java.util.List;

public class UserMapperImpl implements UserMapper {

    @Override
    public User mapToService(org.nogin.entity.User source) {
        return null;
    }

    @Override
    public org.nogin.entity.User mapToDatabase(User source) {
        return null;
    }

    @Override
    public List<User> mapToService(List<org.nogin.entity.User> source) {
        return null;
    }

    @Override
    public List<org.nogin.entity.User> mapToDatabase(List<User> source) {
        return null;
    }
}
