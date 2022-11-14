package org.nogin.rest.controller;

import org.nogin.service.NewsService;
import org.nogin.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/NewsPortal")
public class NewsPortalController {
    private final NewsService newsService;
    private final UserService userService;

    public NewsPortalController(NewsService newsService, UserService userService) {
        this.newsService = newsService;
        this.userService = userService;
    }

    }
