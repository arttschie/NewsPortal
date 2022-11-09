package org.nogin.service.impl;

import org.nogin.service.mapper.NewsMapper;
import org.nogin.service.mapper.UserMapper;
import org.nogin.service.models.News;
import org.nogin.service.models.User;
import org.nogin.database.repository.UserRepository;
import org.nogin.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final NewsMapper newsMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, NewsMapper newsMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.newsMapper = newsMapper;
    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll().stream()
                .map(userMapper::mapToService)
                .collect(Collectors.toList());
    }
    
    @Override
    public User getUserByNews(News news) {
        org.nogin.database.entity.News newsEntity = newsMapper.mapToDatabase(news);
        org.nogin.database.entity.User userEntity = userRepository.findUserByNews(newsEntity);
        User user = userMapper.mapToService(userEntity);
        return user;
    }

    @Override
    public User getById(Long id) {
        org.nogin.database.entity.User entity = userRepository.findById(id);
        User user = userMapper.mapToService(entity);
        return user;
    }
    
    @Override
    public User getByLogin(String login) {
        org.nogin.database.entity.User entity = userRepository.findByLogin(login);
        User user = userMapper.mapToService(entity);
        return user;
    }
    
    @Override
    public User getByPassword(String password) {
        org.nogin.database.entity.User entity = userRepository.findByPassword(password);
        User user = userMapper.mapToService(entity);
        return user;
    }
    
    @Override
    public void createUser() {

    }
    
    @Override
    public User changeUserLogin(User user, String login) {
        return User.builder()
                  .id(user.getId())
                  .login(login)
                  .password(user.getPassword())
                .build();
    }
    
    @Override
    public User changeUserPassword(User user, String password) {
        return User.builder()
                  .id(user.getId())
                  .login(user.getLogin())
                  .password(password)
                .build();
    }
}
