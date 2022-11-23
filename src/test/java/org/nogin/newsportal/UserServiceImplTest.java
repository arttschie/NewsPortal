package org.nogin.newsportal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.nogin.newsportal.service.UserService;
import org.nogin.newsportal.service.models.News;
import org.nogin.newsportal.service.models.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    private final User user = User.builder()
            .id(0L)
            .login("testLogin")
            .password("testPassword")
            .build();
    private final News news = News.builder()
            .id(0L)
            .title("Test title")
            .content("Test content")
            .user(user)
            .build();
    private final List<User> userList = Collections.singletonList(user);
    private final UserService userService = mock(UserService.class);

    @Test
    @DisplayName("Test for getUsers() method")
    public void getUsers() {
        when(userService.getUsers()).thenReturn(userList);
        assertEquals(userList, userService.getUsers());
    }

    @Test
    @DisplayName("Test for getUserByNewsId(Long newsId)  method")
    public void getUserByNewsId() {
        when(userService.getUserByNewsId(news.getId())).thenReturn(Optional.of(user));
        assertEquals(Optional.of(user), userService.getUserByNewsId(news.getId()));
    }

    @Test
    @DisplayName("Test for getById(Long id)  method")
    public void getById() {
        when(userService.getById(user.getId())).thenReturn(Optional.of(user));
        assertEquals(Optional.of(user), userService.getById(user.getId()));
    }

    @Test
    @DisplayName("Test for getByLogin(String login) method")
    public void getByLogin() {
        when(userService.getByLogin(user.getLogin())).thenReturn(Optional.of(user));
        assertEquals(Optional.of(user), userService.getByLogin(user.getLogin()));
    }

    @Test
    @DisplayName("Test for getByPassword(String password) method")
    public void getByPassword() {
        when(userService.getByPassword(user.getPassword())).thenReturn(Optional.of(user));
        assertEquals(Optional.of(user), userService.getByPassword(user.getPassword()));
    }

    @Test
    @DisplayName("Test for createUser(User user) method")
    public void createUser() {
        doNothing().when(userService).createUser(isA(User.class));
        userService.createUser(user);
        verify(userService).createUser(user);
    }

    @Test
    @DisplayName("Test for changeUserLogin(Long userId, String login) method")
    public void changeUserLogin() {
        doNothing().when(userService).changeUserLogin(isA(Long.class), isA(String.class));
        userService.changeUserLogin(user.getId(), user.getLogin());
        verify(userService).changeUserPassword(user.getId(), user.getLogin());
    }

    @Test
    @DisplayName("Test for changeUserPassword(Long userId, String password) method")
    public void changeUserPassword() {
        doNothing().when(userService).changeUserLogin(isA(Long.class), isA(String.class));
        userService.changeUserPassword(user.getId(), user.getPassword());
        verify(userService).changeUserPassword(user.getId(), user.getPassword());
    }
}
