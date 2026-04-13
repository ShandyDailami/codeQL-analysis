import java.sql.*;

public class java_00342_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Prepare SQL statement
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(query);

            // Set parameters
            statement.setString(1, "admin");
            statement.setString(2, "password");

            // Execute SQL statement
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close connections
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}