import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_38832_JDBCQueryHandler_A01 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                System.out.println("Connected to database");
                String userId = "1"; // replace with actual user ID
                checkAccessLevel(connection, userId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    private static void checkAccessLevel(Connection connection, String userId) throws SQLException {
        String query = "SELECT access_level FROM users WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, userId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String accessLevel = resultSet.getString("access_level");
            System.out.println("Access level: " + accessLevel);
        } else {
            System.out.println("No user found with ID: " + userId);
        }
    }
}