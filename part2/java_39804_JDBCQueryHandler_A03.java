import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_39804_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getUserNamesByEmail(String email) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<String> userNames = new ArrayList<>();

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT name FROM users WHERE email='" + email + "'");

            while (resultSet.next()) {
                userNames.add(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }

        return userNames;
    }

    public static void main(String[] args) {
        List<String> userNames = getUserNamesByEmail("test@test.com");
        userNames.forEach(System.out::println);
    }
}