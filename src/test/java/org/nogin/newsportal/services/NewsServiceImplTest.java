package org.nogin.newsportal.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.nogin.newsportal.database.repository.NewsRepository;
import org.nogin.newsportal.database.repository.impl.NewsRepositoryImpl;
import org.nogin.newsportal.service.NewsService;
import org.nogin.newsportal.service.impl.NewsServiceImpl;
import org.nogin.newsportal.service.mapper.NewsMapper;
import org.nogin.newsportal.service.mapper.impl.NewsMapperImpl;
import org.nogin.newsportal.service.models.News;
import org.nogin.newsportal.service.models.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class NewsServiceImplTest {
    private final User user = User.builder()
            .id(0L)
            .login("Test login")
            .password("Test password")
            .build();
    private final News news = News.builder()
            .id(0L)
            .title("Test title")
            .content("Test content")
            .user(user)
            .build();
    private final List<News> newsList = Collections.singletonList(news);
    private final NewsService newsService = mock(NewsService.class);

    @Test
    @DisplayName("Test for getNews() method")
    public void getNews() {
        when(newsService.getNews()).thenReturn(newsList);
        assertEquals(newsList, newsService.getNews());
    }

    @Test
    @DisplayName("Test for getNewsByUserId(Long userId) method")
    public void getByUserId() {
        when(newsService.getNewsByUserId(user.getId())).thenReturn(newsList);
        assertEquals(newsList, newsService.getNewsByUserId(user.getId()));
    }

    @Test
    @DisplayName("Test for getById(Long id) method")
    public void getById() {
        when(newsService.getById(news.getId())).thenReturn(Optional.of(news));
        assertEquals(Optional.of(news), newsService.getById(0L));
    }

    @Test
    @DisplayName("Test for getByTitle(String title) method")
    public void getByTitle() {
        when(newsService.getByTitle("Test title")).thenReturn(Optional.of(news));
        assertEquals(Optional.of(news), newsService.getByTitle("Test title"));
    }

    @Test
    @DisplayName("Test for createNews(News news) method")
    public void createNews() {
        doNothing().when(newsService).createNews(isA(News.class));
        newsService.createNews(news);
        verify(newsService).createNews(news);
    }

    @Test
    @DisplayName("Test for changeNewsTitle(Long newsId, String title) method")
    public void changeNewsTitle() {
        doNothing().when(newsService).changeNewsTitle(isA(Long.class), isA(String.class));
        newsService.changeNewsTitle(news.getId(), news.getTitle());
        verify(newsService).changeNewsTitle(news.getId(), news.getTitle());
    }

    @Test
    @DisplayName("Test for changeNewsContent(Long newsId, String title) method")
    public void changeNewsContent() {
        doNothing().when(newsService).changeNewsContent(isA(Long.class), isA(String.class));
        newsService.changeNewsContent(news.getId(), news.getTitle());
        verify(newsService).changeNewsContent(news.getId(), news.getTitle());
    }
}
