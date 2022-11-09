package org.nogin.database.repository;

import org.nogin.database.entity.News;
import org.nogin.database.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findUserByNews(News news);
    User findById(Long id);
    User findByLogin(String login);
    User findByPassword(String password);
    void insertUser();
    User updateUserLogin(User user, String login);
    User updateUserPassword(User user, String password);
}
