package org.nogin.service.mapper.impl;

import org.nogin.service.mapper.UserMapper;
import org.nogin.service.models.User;

import java.util.List;

public class UserMapperImpl implements UserMapper {

    @Override
    public User mapToService(org.nogin.database.entity.User source) {
        return null;
    }

    @Override
    public org.nogin.database.entity.User mapToDatabase(User source) {
        return null;
    }

    @Override
    public List<User> mapToService(List<org.nogin.database.entity.User> source) {
        return null;
    }

    @Override
    public List<org.nogin.database.entity.User> mapToDatabase(List<User> source) {
        return null;
    }
}
