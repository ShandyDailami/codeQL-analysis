import com.zaxx.utils.ConnectionManager;
import com.zaxx.utils.JdbcUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;

public class java_05879_JDBCQueryHandler_A03 {
    private final ConnectionManager connectionManager;
    private final JdbcUtils jdbcUtils;
    private final PasswordEncoder passwordEncoder;

    public java_05879_JDBCQueryHandler_A03(ConnectionManager connectionManager, JdbcUtils jdbcUtils, BCryptPasswordEncoder passwordEncoder) {
        this.connectionManager = connectionManager;
        this.jdbcUtils = jdbcUtils;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";

        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return Optional.of(new User(
                        rs.getString("username"),
                        passwordEncoder.encode(rs.getString("password")),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            // handle error
        }

        return Optional.empty();
    }
}