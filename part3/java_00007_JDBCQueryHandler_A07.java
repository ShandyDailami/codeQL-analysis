import java.sql.*;

public class java_00007_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, "user1");
                statement.setString(2, "password1");
                ResultSet result = statement.executeQuery();
                if (result.next()) {
                    System.out.println("Authentication successful");
                } else {
                    System.out.println("Authentication failed");
                }
                result.close();
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting connection: " + e.getMessage());
        }
        return connection;
    }
}