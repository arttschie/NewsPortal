package org.nogin.newsportal.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nogin.newsportal.database.repository.NewsRepository;
import org.nogin.newsportal.service.impl.NewsServiceImpl;
import org.nogin.newsportal.service.mapper.NewsMapper;
import org.nogin.newsportal.service.models.News;
import org.nogin.newsportal.service.models.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NewsServiceImplTest {
    private static User userService;
    private static News newsService;
    private static org.nogin.newsportal.database.entity.User userDatabase;
    private static org.nogin.newsportal.database.entity.News newsDatabase;
    private static List<News> newsList;

    @BeforeAll
    public static void init() {
        userService = User.builder()
                .id(0L)
                .login("Test login")
                .password("Test password")
                .build();

        newsService = News.builder()
                .id(0L)
                .title("Test title")
                .content("Test content")
                .user(userService)
                .build();

        userDatabase = org.nogin.newsportal.database.entity.User.builder()
                .id(0L)
                .login("Test login")
                .password("Test password")
                .build();

        newsDatabase = org.nogin.newsportal.database.entity.News.builder()
                .id(0L)
                .content("Test content")
                .title("Test title")
                .user(userDatabase)
                .build();

        newsList = Collections.singletonList(newsService);
    }

    @InjectMocks
    private NewsServiceImpl newsServiceImpl;

    @Mock
    private NewsRepository newsRepository;

    @Mock
    private NewsMapper newsMapper;

    @Test
    @DisplayName("Test for getNews() method")
    public void getNews() {
        newsServiceImpl.getNews();
        verify(newsRepository).findAll();
    }

    @Test
    @DisplayName("Test for getNewsByUserId(Long userId) method")
    public void getByUserId() {
        when(newsServiceImpl.getNewsByUserId(userService.getId())).thenReturn(newsList);
        assertEquals(newsList, newsServiceImpl.getNewsByUserId(userService.getId()));
    }

    @Test
    @DisplayName("Test for getById(Long id) method")
    public void getById() {
        when(newsServiceImpl.getById(newsService.getId())).thenReturn(Optional.of(newsService));
        assertEquals(Optional.of(newsService), newsServiceImpl.getById(0L));
    }

    @Test
    @DisplayName("Test for getByTitle(String title) method")
    public void getByTitle() {
        when(newsServiceImpl.getByTitle("Test title")).thenReturn(Optional.of(newsService));
        assertEquals(Optional.of(newsService), newsServiceImpl.getByTitle("Test title"));
    }

    @Test
    @DisplayName("Test for createNews(News news) method")
    public void createNews() {
        newsServiceImpl.createNews(newsService);
        verify(newsRepository).createNews(any());
        verify(newsMapper).mapToDatabase(any(News.class));
    }

    @Test
    @DisplayName("Test for changeNewsTitle(Long newsId, String title) method")
    public void changeNewsTitle() {
        doNothing().when(newsServiceImpl).changeNewsTitle(isA(Long.class), isA(String.class));
        newsServiceImpl.changeNewsTitle(newsService.getId(), newsService.getTitle());
        verify(newsServiceImpl).changeNewsTitle(newsService.getId(), newsService.getTitle());
    }

    @Test
    @DisplayName("Test for changeNewsContent(Long newsId, String title) method")
    public void changeNewsContent() {
        doNothing().when(newsServiceImpl).changeNewsContent(isA(Long.class), isA(String.class));
        newsServiceImpl.changeNewsContent(newsService.getId(), newsService.getTitle());
        verify(newsServiceImpl).changeNewsContent(newsService.getId(), newsService.getTitle());
    }
}
