package org.nogin.rest.controller;

import org.nogin.service.NewsService;
import org.nogin.service.UserService;
import org.nogin.service.models.News;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Object> getNews() {
        return ResponseEntity.ok().body(newsService.getNews());
    }

    @GetMapping("/news/userId")
    public ResponseEntity<Object> getNewsByUserId(@RequestParam Long userId) {
        return ResponseEntity.ok().body(newsService.getNewsByUserId(userId));
    }

    @GetMapping("/news/id")
    public ResponseEntity<Object> getNewsById(@RequestParam Long id) {
        return ResponseEntity.ok().body(newsService.getById(id));
    }

    @GetMapping("/news/title")
    public ResponseEntity<Object> getNewsByTitle(@RequestParam String title) {
        return ResponseEntity.ok().body(newsService.getByTitle(title));
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
