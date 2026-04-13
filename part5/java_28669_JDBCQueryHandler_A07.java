import java.sql.*;
import org.mindrot.jbcrypt.*;

public class java_28669_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String selectSQL = "SELECT password FROM users WHERE username = ?";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(selectSQL);

                if (resultSet.next()) {
                    String hashedPassword = resultSet.getString(1);
                    if (BCrypt.checkpw("password", hashedPassword)) {
                        System.out.println("Password is correct!");
                    } else {
                        System.out.println("Password is incorrect!");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}