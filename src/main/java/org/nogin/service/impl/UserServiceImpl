package org.nogin.service.impl;

import org.nogin.mapper.NewsMapper;
import org.nogin.models.News;
import org.nogin.models.User;
import org.nogin.repository.NewsRepository;
import org.nogin.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository newsRepository, UserMapper newsMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll().stream()
                .map(userMapper::mapToService)
                .collect(Collectors.toList());
    }
    
    @Override
    public User getUserByNews(News news) {  
        org.nogin.entity.User entity = userRepository.findUserByNews(news);
        User user = userMapper.mapToService(entity);
        return user;
    }

    @Override
    public User getById(Long id) {
        org.nogin.entity.User entity = userRepository.findById(id);
        User user = userMapper.mapToService(entity);
        return user;
    }
    
    @Override
    User getByLogin(String login) {
        org.nogin.entity.User entity = userRepository.findByLogin(login);
        User user = userMapper.mapToService(entity);
        return user;
    }
    
    @Override
    User getByPassword(String password) {
        org.nogin.entity.User entity = userRepository.findByPassword(password);
        User user = userMapper.mapToService(entity);
        return user;
    }
    
    @Override
    void createUser() {
        User user = new User.builder()
                            .id()
                            .login()
                            .password()
                          .build();
    }
    
    @Override
    User changeUserLogin(User user, String login) {
        return new User.builder()
                          .id(user.getId())
                          .login(login)
                          .password(user.getPassword())
                        .build();          
    }
    
    @Override
    User changeUserPassword(User user, String password) {
        return new User.builder()
                          .id(user.getId())
                          .login(user.getLogin())
                          .password(password)
                        .build();          
    }
}
