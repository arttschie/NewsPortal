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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NewsServiceImplTest {
    private static User userService;
    private static News newsService;

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
        newsServiceImpl.getNewsByUserId(anyLong());
        verify(newsRepository).findAllByUserId(anyLong());
    }

    @Test
    @DisplayName("Test for getById(Long id) method")
    public void getById() {
        newsServiceImpl.getById(anyLong());
        verify(newsRepository).findById(anyLong());
    }

    @Test
    @DisplayName("Test for getByTitle(String title) method")
    public void getByTitle() {
        newsServiceImpl.getByTitle("Test title");
        verify(newsRepository).findByTitle(anyString());
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
        newsServiceImpl.changeNewsTitle(anyLong(), anyString());
        verify(newsRepository).updateNewsTitle(anyLong(), anyString());
    }

    @Test
    @DisplayName("Test for changeNewsContent(Long newsId, String title) method")
    public void changeNewsContent() {
        newsServiceImpl.changeNewsContent(anyLong(), anyString());
        verify(newsRepository).updateNewsContent(anyLong(), anyString());
    }
}
