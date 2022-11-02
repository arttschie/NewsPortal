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
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    public NewsServiceImpl(NewsRepository newsRepository, NewsMapper newsMapper) {
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
    }

    @Override
    public List<News> getNews() {
        return this.newsRepository.findAll().stream()
                .map(newsMapper::mapToService)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<News> getNewsByUser(User user) {
        return this.newsRepository.findAllByUser.stream()
            .map(newsMapper::mapToService())
            .collect(Collectors.toList());
    }

    @Override
    public News getById(Long id) {
        org.nogin.entity.News entity = newsRepository.findById(id);
        News news = newsMapper.mapToService(entity);
        return news;
    }

    @Override
    public News getByTitle(String title) {
        return newsRepository.findByTitle(title)
                .map(newsMapper::mapToService)
                .orElse(null);
    }
    
    @Override
    public void createNews(User user) {
        News news = new News().builder()
                        .id()
                        .title()
                        .content()
                        .user(user)
                    .build();
    }
    
    @Override
    public News changeNewsTitle(News news, User user) {
        
    }
    
    @Override
    public News changeNewsContent(News news, User user) {
        
    }
}
