package org.nogin.service.impl;

import org.nogin.database.repository.NewsRepository;
import org.nogin.service.NewsService;
import org.nogin.service.mapper.NewsMapper;
import org.nogin.service.mapper.UserMapper;
import org.nogin.service.models.News;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;
    private final UserMapper userMapper;

    public NewsServiceImpl(NewsRepository newsRepository, NewsMapper newsMapper, UserMapper userMapper) {
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
        this.userMapper = userMapper;
    }


    @Override
    public List<News> getNews() {
        return newsRepository.findAll().stream()
                .map(newsMapper::mapToService)
                .collect(Collectors.toList());
    }

    @Override
    public List<News> getNewsByUserId(Long userId) {
        return newsRepository.findAllByUserId(userId).stream()
                .map(newsMapper::mapToService)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<News> getById(Long id) {
        return newsRepository.findById(id).map(newsMapper::mapToService);
    }

    @Override
    public Optional<News> getByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public void createNews(News news) {

    }

    @Override
    public void changeNewsTitle(Long newsId, String title) {

    }

    @Override
    public void changeNewsContent(Long newsId, String content) {

    }
}
