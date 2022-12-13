package org.nogin.newsportal;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nogin.newsportal.database.repository.UserRepository;
import org.nogin.newsportal.database.repository.impl.UserRepositoryImpl;
import org.nogin.newsportal.database.util.HibernateUtil;
import org.nogin.newsportal.service.UserService;
import org.nogin.newsportal.service.impl.UserServiceImpl;
import org.nogin.newsportal.service.mapper.UserMapper;
import org.nogin.newsportal.service.mapper.impl.UserMapperImpl;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
@ExtendWith(MockitoExtension.class)
public class NewsPortalIntegrationTest {
    @Container
    private static final OracleContainer oracle = new OracleContainer(DockerImageName.parse("gvenzl/oracle-xe"));

    private static UserService userService;
    private static UserRepository userRepository;
    private static UserMapper userMapper;
    private static SessionFactory sessionFactory;

    @BeforeAll
    public static void startUp() {
        System.out.println(oracle.getPassword());
        System.out.println(oracle.getUsername());
        System.out.println(oracle.getJdbcUrl());
//        oracle.start();
        sessionFactory = HibernateUtil.getSessionFactory();
        userMapper = new UserMapperImpl();
        userRepository = new UserRepositoryImpl(sessionFactory);
        userService = new UserServiceImpl(userRepository, userMapper);
    }

    @Test
    public void createUserTest() {
        System.out.println(oracle.getPassword());
        System.out.println(oracle.getUsername());
        System.out.println(oracle.getJdbcUrl());
//        userService.createUser(User.builder()
//                .id(0L)
//                .login("Test login")
//                .password("Test password")
//                .build());
//
//        User user = userService.getById(0L).get();
//        System.out.println(user);
    }

    @AfterAll
    public static void shutDown() {
        oracle.stop();
    }
}
