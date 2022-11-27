package org.nogin.newsportal;

import com.sun.javaws.jnl.RContentDesc;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.nogin.newsportal.database.repository.UserRepository;
import org.nogin.newsportal.database.repository.impl.UserRepositoryImpl;
import org.nogin.newsportal.service.UserService;
import org.nogin.newsportal.service.impl.UserServiceImpl;
import org.nogin.newsportal.service.mapper.UserMapper;
import org.nogin.newsportal.service.mapper.impl.UserMapperImpl;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Testcontainers
public class NewsPortalIntegrationTest {
    private Connection connection;
    private PreparedStatement preparedStatement;

    @Container
    private static final OracleContainer oracle = new OracleContainer(DockerImageName.parse("oracleinanutshell/oracle-xe-11g"));

    @Mock
    private UserService userService;

    @BeforeAll
    public static void startUp() throws SQLException {
        oracle.start();
    }

    @Test
    public void createUserTest() throws SQLException {
        preparedStatement = connection.prepareStatement("");
        
    }

    @AfterAll
    public static void shutDown() {
        oracle.stop();
    }
}
