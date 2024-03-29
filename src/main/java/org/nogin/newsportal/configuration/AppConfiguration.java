package org.nogin.newsportal.configuration;

import org.hibernate.SessionFactory;
import org.nogin.newsportal.database.repository.NewsRepository;
import org.nogin.newsportal.database.repository.UserRepository;
import org.nogin.newsportal.database.repository.impl.NewsRepositoryImpl;
import org.nogin.newsportal.database.repository.impl.UserRepositoryImpl;
import org.nogin.newsportal.database.util.ConnectionPool;
import org.nogin.newsportal.database.util.HibernateUtil;
import org.nogin.newsportal.service.NewsService;
import org.nogin.newsportal.service.UserService;
import org.nogin.newsportal.service.impl.NewsServiceImpl;
import org.nogin.newsportal.service.impl.UserServiceImpl;
import org.nogin.newsportal.service.mapper.NewsMapper;
import org.nogin.newsportal.service.mapper.UserMapper;
import org.nogin.newsportal.service.mapper.impl.NewsMapperImpl;
import org.nogin.newsportal.service.mapper.impl.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("org.nogin.newsportal")
@EnableWebMvc
@PropertySource("classpath:database.property")
public class AppConfiguration {
    private final Environment environment;

    public AppConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public SessionFactory sessionFactory() {
        return HibernateUtil.getSessionFactory();
    }

    @Bean
    public NewsRepository newsRepository(SessionFactory sessionFactory) {
        return new NewsRepositoryImpl(sessionFactory);
    }

    @Bean
    public UserRepository userRepository(SessionFactory sessionFactory) {
        return new UserRepositoryImpl(sessionFactory);
    }

    @Bean
    public NewsMapper newsMapper() {
        return new NewsMapperImpl();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public NewsService newsService(NewsMapper newsMapper, NewsRepository newsRepository) {
        return new NewsServiceImpl(newsRepository, newsMapper);
    }

    @Bean
    public UserService userService(UserMapper userMapper, UserRepository userRepository) {
        return new UserServiceImpl(userRepository, userMapper);
    }

    @Bean
    public ConnectionPool connectionPool() {
        return new ConnectionPool((
                environment.getProperty("url"),
                environment.getProperty("username"),
                environment.getProperty("password"),
                environment.getProperty("driver"),
                environment.getProperty("minConnections"),
                environment.getProperty("maxConnections")
        );
    }
}
