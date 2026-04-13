import java.sql.*;

public class java_22958_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM your_table";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next()) {
                        // handle the result set here
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}