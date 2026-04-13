import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_23642_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";
        String query = "SELECT * FROM users WHERE username = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                // Set the parameter value
                statement.setString(1, "admin");

                // Execute the query
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("username"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}