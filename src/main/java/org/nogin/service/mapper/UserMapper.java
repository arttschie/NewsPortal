package org.nogin.mapper;

import org.nogin.models.User;

import java.util.List;

public interface UserMapper {
    User mapToService(org.nogin.entity.User source);
    org.nogin.entity.User mapToDatabase(User source);
    List<User> mapToService(List<org.nogin.entity.User> source);
    List<org.nogin.entity.User> mapToDatabase(List<User> source);
}
