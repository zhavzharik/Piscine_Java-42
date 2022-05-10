package edu.school21.repositories;

import org.junit.jupiter.api.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class EmbeddedDataSourceTest {
    private DataSource dataSource;
    private Connection connection;

    @BeforeEach
    void init() {
        dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
    }

    @DisplayName("I'm testConnection")
    @Test
    void testConnection() throws SQLException {
        connection = dataSource.getConnection();
        Assertions.assertNotNull(connection);
    }

    @AfterEach
    void closeConnection() throws SQLException {
        connection.close();
    }
}
