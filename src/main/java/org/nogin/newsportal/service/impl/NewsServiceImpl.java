package org.nogin.newsportal.service.impl;

import org.nogin.newsportal.database.repository.NewsRepository;
import org.nogin.newsportal.service.NewsService;
import org.nogin.newsportal.service.mapper.NewsMapper;
import org.nogin.newsportal.service.models.News;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    public NewsServiceImpl(NewsRepository newsRepository, NewsMapper newsMapper) {
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
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
        return newsRepository.findByTitle(title).map(newsMapper::mapToService);
    }

    @Override
    public void createNews(News news) {
        newsRepository.createNews(newsMapper.mapToDatabase(news));
    }

    @Override
    public void changeNewsTitle(Long newsId, String title) {
        newsRepository.updateNewsTitle(newsId, title);
    }

    @Override
    public void changeNewsContent(Long newsId, String content) {
        newsRepository.updateNewsContent(newsId, content);
    }
}
