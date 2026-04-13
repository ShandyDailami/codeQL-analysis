import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_01161_JDBCQueryHandler_A07 {
    private HikariConfig config;
    private HikariDataSource ds;

    public java_01161_JDBCQueryHandler_A07() {
        config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        config.setUsername("username");
        config.setPassword("password");
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        ds = new HikariDataSource(config);
    }

    public void authenticateUser(String username, String password) {
        try (Connection conn = ds.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("User authenticated successfully.");
            } else {
                System.out.println("Authentication failed.");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while executing the query. " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        AuthFailureHandler authFailureHandler = new AuthFailureHandler();
        authFailureHandler.authenticateUser("test", "test");
    }
}