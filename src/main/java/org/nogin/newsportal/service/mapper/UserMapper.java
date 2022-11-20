package org.nogin.newsportal.service.mapper;

import org.nogin.newsportal.service.models.User;

import java.util.List;

public interface UserMapper {
    User mapToService(org.nogin.newsportal.database.entity.User source);
    org.nogin.newsportal.database.entity.User mapToDatabase(User source);
    List<User> mapToService(List<org.nogin.newsportal.database.entity.User> source);
    List<org.nogin.newsportal.database.entity.User> mapToDatabase(List<User> source);
}
