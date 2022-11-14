package org.nogin.database.repository;

import org.nogin.database.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();
    Optional<User> findUserByNewsId(Long newsId);
    Optional<User> findById(Long id);
    Optional<User> findByLogin(String login);
    Optional<User> findByPassword(String password);
    void createUser();
    Optional<User> updateUserLogin(Long userId, String login);
    Optional<User> updateUserPassword(Long userId, String password);
}
