package org.nogin.repository;

import org.nogin.entity.News;

import java.util.List;
import java.util.Optional;

public interface NewsRepository {
    List<News> findAll();
    News findById(Long id);
    Optional<News> findByTitle(String title);
}
