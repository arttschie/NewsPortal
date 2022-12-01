package org.nogin.newsportal;

import org.nogin.newsportal.configuration.AppConfiguration;
import org.nogin.newsportal.service.NewsService;
import org.nogin.newsportal.service.UserService;
import org.nogin.newsportal.service.impl.NewsServiceImpl;
import org.nogin.newsportal.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NewsPortalApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        NewsService newsService = applicationContext.getBean(NewsServiceImpl.class);
        UserService userService = applicationContext.getBean(UserServiceImpl.class);
    }
}
