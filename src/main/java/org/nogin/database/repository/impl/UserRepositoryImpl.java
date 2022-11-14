package org.nogin.database.repository.impl;

import org.nogin.database.entity.User;
import org.nogin.database.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findUserByNewsId(Long newsId) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByPassword(String password) {
        return Optional.empty();
    }

    @Override
    public void createUser() {

    }

    @Override
    public Optional<User> updateUserLogin(Long userId, String login) {
        return Optional.empty();
    }

    @Override
    public Optional<User> updateUserPassword(Long userId, String password) {
        return Optional.empty();
    }
}
