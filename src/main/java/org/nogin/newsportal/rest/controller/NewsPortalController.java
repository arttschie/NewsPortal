package org.nogin.newsportal.rest.controller;

import org.nogin.newsportal.service.NewsService;
import org.nogin.newsportal.service.UserService;
import org.nogin.newsportal.service.models.News;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/NewsPortal")
public class NewsPortalController {
    private final NewsService newsService;
    private final UserService userService;

    public NewsPortalController(NewsService newsService, UserService userService) {
        this.newsService = newsService;
        this.userService = userService;
    }

    @GetMapping("/news")
    public ResponseEntity<List<News>> getNews() {
        return ResponseEntity.ok().body(newsService.getNews());
    }

    @GetMapping("/news/userId")
    public ResponseEntity<List<News>> getNewsByUserId(@RequestParam Long userId) {
        return ResponseEntity.ok().body(newsService.getNewsByUserId(userId));
    }

    @GetMapping("/news/id")
    public ResponseEntity<News> getNewsById(@RequestParam Long id) {
        return newsService.getById(id)
                .map(news -> ResponseEntity.ok().body(news))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/news/title")
    public ResponseEntity<News> getNewsByTitle(@RequestParam String title) {
        return newsService.getByTitle(title)
                .map(news -> ResponseEntity.ok().body(news))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/news/create")
    public ResponseEntity<Object> createNews(@RequestBody News news) {
        newsService.createNews(news);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/news/update/title")
    public ResponseEntity<Object> changeNewsTitle(@RequestParam Long newsId,
                                                  @RequestParam String title) {
        newsService.changeNewsTitle(newsId, title);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/news/update/content")
    public ResponseEntity<Object> changeNewsContent(@RequestParam Long newsId,
                                                    @RequestParam String content) {
        newsService.changeNewsContent(newsId, content);
        return ResponseEntity.ok().build();
    }
}
