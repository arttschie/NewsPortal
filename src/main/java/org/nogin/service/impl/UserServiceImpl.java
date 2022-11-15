package org.nogin.service.impl;

import org.nogin.database.repository.UserRepository;
import org.nogin.service.UserService;
import org.nogin.service.mapper.UserMapper;
import org.nogin.service.models.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::mapToService)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> getUserByNewsId(Long newsId) {
        return userRepository.findUserByNewsId(newsId).map(userMapper::mapToService);
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id).map(userMapper::mapToService);
    }

    @Override
    public Optional<User> getByLogin(String login) {
        return userRepository.findByLogin(login).map(userMapper::mapToService);
    }

    @Override
    public Optional<User> getByPassword(String password) {
        return userRepository.findByPassword(password).map(userMapper::mapToService);
    }

    @Override
    public void createUser(User user) {
        userRepository.createUser(userMapper.mapToDatabase(user));
    }

    @Override
    public void changeUserLogin(Long userId, String login) {
        userRepository.updateUserLogin(userId, login);
    }

    @Override
    public void changeUserPassword(Long userId, String password) {
        userRepository.updateUserPassword(userId, password);
    }
}
