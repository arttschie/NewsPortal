package org.nogin.service;

import org.nogin.service.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();
    Optional<User> getUserByNewsId(Long newsId);
    Optional<User> getById(Long id);
    Optional<User> getByLogin(String login);
    Optional<User> getByPassword(String password);
    void createUser(User user);
    void changeUserLogin(Long userId, String login);
    void changeUserPassword(Long userId, String password);
}

