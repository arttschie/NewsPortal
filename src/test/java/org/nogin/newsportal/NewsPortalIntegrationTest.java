package org.nogin.newsportal;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nogin.newsportal.database.repository.NewsRepository;
import org.nogin.newsportal.database.repository.UserRepository;
import org.nogin.newsportal.database.repository.impl.NewsRepositoryImpl;
import org.nogin.newsportal.database.repository.impl.UserRepositoryImpl;
import org.nogin.newsportal.service.NewsService;
import org.nogin.newsportal.service.UserService;
import org.nogin.newsportal.service.impl.NewsServiceImpl;
import org.nogin.newsportal.service.impl.UserServiceImpl;
import org.nogin.newsportal.service.mapper.NewsMapper;
import org.nogin.newsportal.service.mapper.UserMapper;
import org.nogin.newsportal.service.mapper.impl.NewsMapperImpl;
import org.nogin.newsportal.service.mapper.impl.UserMapperImpl;
import org.nogin.newsportal.service.models.News;
import org.nogin.newsportal.service.models.User;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.Properties;

@Testcontainers
public class NewsPortalIntegrationTest {
    @Container
    private static final OracleContainer oracle = new OracleContainer(DockerImageName.parse("gvenzl/oracle-xe"));

    private static UserService userService;
    private static UserRepository userRepository;
    private static UserMapper userMapper;

    private static NewsService newsService;
    private static NewsRepository newsRepository;
    private static NewsMapper newsMapper;

    private static SessionFactory sessionFactory;
    private static Properties connectionProps;

    private User user;

    @BeforeAll
    public static void startUp() {
        oracle.start();
        connectionProps = new Properties();
        connectionProps.put("hibernate.connection.driver_class", "oracle.jdbc.OracleDriver");
        connectionProps.put("hibernate.connection.url", oracle.getJdbcUrl());
        connectionProps.put("hibernate.connection.username", oracle.getUsername());
        connectionProps.put("hibernate.connection.password", oracle.getPassword());
        connectionProps.put("hibernate.dialect", "org.hibernate.dialect.Oracle8iDialect");
        connectionProps.put("show_sql", true);
        connectionProps.put("hibernate.hbm2ddl.auto", "create-drop");
        sessionFactory = new Configuration()
                .addProperties(connectionProps)
                .addAnnotatedClass(org.nogin.newsportal.database.entity.News.class)
                .addAnnotatedClass(org.nogin.newsportal.database.entity.User.class)
                .buildSessionFactory();
        userMapper = new UserMapperImpl();
        userRepository = new UserRepositoryImpl(sessionFactory);
        userService = new UserServiceImpl(userRepository, userMapper);
        newsMapper = new NewsMapperImpl();
        newsRepository = new NewsRepositoryImpl(sessionFactory);
        newsService = new NewsServiceImpl(newsRepository, newsMapper);
    }

    @BeforeEach
    public void beforeEachTest() {
        user = User.builder()
                .login("Test login")
                .password("Test password")
                .build();
    }

    @Test
    public void NewsPortalIntegrationTest() {
        userService.createUser(user);
        User userAcquired = userService.getByLogin(user.getLogin()).orElse(new User());
        newsService.createNews(News.builder()
                .content("Test content")
                .title("Test title")
                .user(userAcquired)
                .build());

        newsService.getNews();
        newsService.getNewsByUserId(user.getId());
        News newsAcquired = newsService.getByTitle("Test title").orElse(new News());
        newsService.getById(newsAcquired.getId());
        newsService.changeNewsTitle(newsAcquired.getId(), "Changed title");
        newsService.changeNewsContent(newsAcquired.getId(), "Changed content");

        userService.getUsers();
        userService.getUserByNewsId(userAcquired.getId());
        userService.getById(userAcquired.getId());
        userService.getByPassword("Test password");
        userService.changeUserLogin(userAcquired.getId(), "Changed login");
        userService.changeUserPassword(userAcquired.getId(), "Changed password");
    }

    @AfterAll
    public static void shutDown() {
        oracle.stop();
    }
}
