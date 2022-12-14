package org.nogin.newsportal.database.repository;

import org.nogin.newsportal.database.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();
    Optional<User> findUserByNewsId(Long newsId);
    Optional<User> findById(Long id);
    Optional<User> findByLogin(String login);
    Optional<User> findByPassword(String password);
    void createUser(User user);
    void updateUserLogin(Long userId, String login);
    void updateUserPassword(Long userId, String password);
}
