package org.nogin.service.mapper;

import org.nogin.service.models.User;

import java.util.List;

public interface UserMapper {
    User mapToService(org.nogin.database.entity.User source);
    org.nogin.database.entity.User mapToDatabase(User source);
    List<User> mapToService(List<org.nogin.database.entity.User> source);
    List<org.nogin.database.entity.User> mapToDatabase(List<User> source);
}
