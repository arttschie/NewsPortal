package org.nogin.newsportal;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nogin.newsportal.database.repository.UserRepository;
import org.nogin.newsportal.database.repository.impl.UserRepositoryImpl;
import org.nogin.newsportal.service.UserService;
import org.nogin.newsportal.service.impl.UserServiceImpl;
import org.nogin.newsportal.service.mapper.UserMapper;
import org.nogin.newsportal.service.mapper.impl.UserMapperImpl;
import org.nogin.newsportal.service.models.User;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Properties;

@Testcontainers
public class NewsPortalIntegrationTest {
    @Container
    private static final OracleContainer oracle = new OracleContainer(DockerImageName.parse("gvenzl/oracle-xe"));

    private static UserService userService;
    private static UserRepository userRepository;
    private static UserMapper userMapper;
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
        sessionFactory = new Configuration().addProperties(connectionProps).buildSessionFactory();
        userMapper = new UserMapperImpl();
        userRepository = new UserRepositoryImpl(sessionFactory);
        userService = new UserServiceImpl(userRepository, userMapper);
    }

    @BeforeEach
    public void beforeEachTest() {
        user = User.builder()
                .id(0L)
                .login("Test login")
                .password("Test password")
                .build();
    }

    @Test
    public void createUserTest() {
        userService.createUser(user);
//        assertThat(userService.getUsers()).isEqualTo(Arrays.asList(user));
//        assertThat(userService.getById(0L)).isEqualTo(user);
//        assertThat(userService.getByLogin("Test login")).isEqualTo(user);
//        assertThat(userService.getByPassword("Test login")).isEqualTo(user);
//        System.out.println(sessionFactory);
    }

    @AfterAll
    public static void shutDown() {
        oracle.stop();
    }
}
