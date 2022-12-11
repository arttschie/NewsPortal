package org.nogin.newsportal;

import com.sun.javaws.jnl.RContentDesc;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.internal.SessionFactoryImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nogin.newsportal.database.repository.UserRepository;
import org.nogin.newsportal.database.repository.impl.UserRepositoryImpl;
import org.nogin.newsportal.database.util.HibernateUtil;
import org.nogin.newsportal.service.UserService;
import org.nogin.newsportal.service.impl.UserServiceImpl;
import org.nogin.newsportal.service.mapper.UserMapper;
import org.nogin.newsportal.service.mapper.impl.UserMapperImpl;
import org.nogin.newsportal.service.models.User;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Testcontainers
@ExtendWith(MockitoExtension.class)
public class NewsPortalIntegrationTest {
    @Container
    private static final OracleContainer oracle = new OracleContainer(DockerImageName.parse("gvenzl/oracle-xe"))
            .withPassword("test")
            .withUsername("test");

    private static UserService userService;
    private static UserRepository userRepository;
    private static UserMapper userMapper;
    private static SessionFactory sessionFactory;

    @BeforeAll
    public static void startUp() {
        oracle.start();
        sessionFactory = HibernateUtil.getSessionFactory();
        userMapper = new UserMapperImpl();
        userRepository = new UserRepositoryImpl(sessionFactory);
        userService = new UserServiceImpl(userRepository, userMapper);
        System.out.println(oracle.getPassword());
        System.out.println(oracle.getUsername());
        System.out.println(oracle.getJdbcUrl());
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
