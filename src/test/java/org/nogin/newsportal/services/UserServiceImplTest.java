package org.nogin.newsportal.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nogin.newsportal.database.repository.UserRepository;
import org.nogin.newsportal.service.impl.UserServiceImpl;
import org.nogin.newsportal.service.mapper.UserMapper;
import org.nogin.newsportal.service.models.News;
import org.nogin.newsportal.service.models.User;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    private static User user;
    private static News news;

    @BeforeAll
    public static void init() {
        user = User.builder()
                .id(0L)
                .login("Test login")
                .password("Test password")
                .build();

        news = News.builder()
                .id(0L)
                .title("Test title")
                .content("Test content")
                .user(user)
                .build();
    }

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    @DisplayName("Test for getUsers() method")
    public void getUsers() {
        userServiceImpl.getUsers();
        verify(userRepository).findAll();
    }

    @Test
    @DisplayName("Test for getUserByNewsId(Long newsId)  method")
    public void getUserByNewsId() {
        userServiceImpl.getUserByNewsId(anyLong());
        verify(userRepository).findUserByNewsId(anyLong());
    }

    @Test
    @DisplayName("Test for getById(Long id)  method")
    public void getById() {
        userServiceImpl.getById(anyLong());
        verify(userRepository).findById(anyLong());
    }

    @Test
    @DisplayName("Test for getByLogin(String login) method")
    public void getByLogin() {
        userServiceImpl.getByLogin(anyString());
        verify(userRepository).findByLogin(anyString());
    }

    @Test
    @DisplayName("Test for getByPassword(String password) method")
    public void getByPassword() {
        userServiceImpl.getByPassword(anyString());
        verify(userRepository).findByPassword(anyString());
    }

    @Test
    @DisplayName("Test for createUser(User user) method")
    public void createUser() {
        userServiceImpl.createUser(user);
        verify(userMapper).mapToDatabase(any(User.class));
        verify(userRepository).createUser(any());
    }

    @Test
    @DisplayName("Test for changeUserLogin(Long userId, String login) method")
    public void changeUserLogin() {
        userServiceImpl.changeUserLogin(anyLong(), anyString());
        verify(userRepository).updateUserLogin(anyLong(), anyString());
    }

    @Test
    @DisplayName("Test for changeUserPassword(Long userId, String password) method")
    public void changeUserPassword() {
        userServiceImpl.changeUserPassword(anyLong(), anyString());
        verify(userRepository).updateUserPassword(anyLong(), anyString());
    }
}
