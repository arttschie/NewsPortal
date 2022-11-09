package org.nogin.service.impl;

import org.nogin.service.mapper.NewsMapper;
import org.nogin.service.mapper.UserMapper;
import org.nogin.service.models.News;
import org.nogin.service.models.User;
import org.nogin.database.repository.NewsRepository;
import org.nogin.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return this.newsRepository.findAll().stream()
                .map(newsMapper::mapToService)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<News> getNewsByUser(User user) {
        org.nogin.database.entity.User userEntity = userMapper.mapToDatabase(user);
        return this.newsRepository.findAllByUser(userEntity).stream()
            .map(newsMapper::mapToService)
            .collect(Collectors.toList());
    }

    @Override
    public News getById(Long id) {
        org.nogin.database.entity.News entity = newsRepository.findById(id);
        return newsMapper.mapToService(entity);
    }

    @Override
    public News getByTitle(String title) {
        return newsRepository.findByTitle(title)
                .map(newsMapper::mapToService)
                .orElse(null);
    }
    
    @Override
    public News createNews(News news) {
        org.nogin.database.entity.News entity = newsMapper.mapToDatabase(news);
        org.nogin.database.entity.News created = newsRepository.createNews(entity);
        return newsMapper.mapToService(created);
    }

    @Override
    public News changeNewsTitle(News news, String title) {
        return null;
    }

    @Override
    public News changeNewsContent(News news, String content) {
        return null;
    }
}
