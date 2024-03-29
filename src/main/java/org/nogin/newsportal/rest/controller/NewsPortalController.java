package org.nogin.newsportal.rest.controller;

import org.nogin.newsportal.service.NewsService;
import org.nogin.newsportal.service.UserService;
import org.nogin.newsportal.service.models.News;
import org.nogin.newsportal.service.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/news-portal")
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

    @PostMapping("/news/user{userId}")
    public ResponseEntity<List<News>> getNewsByUserId(@PathVariable(value = "userId") Long userId) {
        return ResponseEntity.ok().body(newsService.getNewsByUserId(userId));
    }

    @GetMapping("/news/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable(value = "id") Long id) {
        return newsService.getById(id)
                .map(news -> ResponseEntity.ok().body(news))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/news/{title}")
    public ResponseEntity<News> getNewsByTitle(@PathVariable(value = "title") String title) {
        return newsService.getByTitle(title)
                .map(news -> ResponseEntity.ok().body(news))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/news")
    public ResponseEntity<Object> createNews(@RequestBody News news) {
        newsService.createNews(news);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/news/title")
    public ResponseEntity<Object> changeNewsTitle(@RequestParam Long newsId,
                                                  @RequestParam String title) {
        newsService.changeNewsTitle(newsId, title);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/news/content")
    public ResponseEntity<Object> changeNewsContent(@RequestParam Long newsId,
                                                    @RequestParam String content) {
        newsService.changeNewsContent(newsId, content);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/users/news/{newsId}")
    public ResponseEntity<User> getUsersByNewsId(@PathVariable(value = "newsId") Long newsId) {
        return ResponseEntity.ok().body(userService.getUserByNewsId(newsId).get());
    }
    
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(userService.getById(id).get());
    }

    @PostMapping("/users/{login}")
    public ResponseEntity<User> getUserByLogin(@PathVariable(value = "login") String login) {
        return ResponseEntity.ok().body(userService.getByLogin(login).get());
    }

    @PostMapping("/users/password")
    public ResponseEntity<User> getUserByPassword(@RequestParam String password) {
        return ResponseEntity.ok().body(userService.getByLogin(password).get());
    }
    
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/users/login")
    public ResponseEntity<Object> changeUserLogin(@RequestParam Long id,
                                                  @RequestParam String login) {
        userService.changeUserLogin(id, login);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/users/password")
    public ResponseEntity<Object> changeUserPassword(@RequestParam Long id,
                                                     @RequestParam String password) {
        userService.changeUserPassword(id, password);
        return ResponseEntity.ok().build();
    }
}
