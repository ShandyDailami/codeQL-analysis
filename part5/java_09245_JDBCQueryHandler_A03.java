import java.sql.*;

public class java_09245_JDBCQueryHandler_A03 {
    // private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    // private static final String USER = "root";
    // private static final String PASSWORD = "password";
    private static Connection connection;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
            // String query = "SELECT * FROM users";
            // Statement statement = connection.createStatement();
            // ResultSet resultSet = statement.executeQuery(query);
            // while (resultSet.next()) {
            //     String username = resultSet.getString("username");
            //     String password = resultSet.getString("password");
            //     System.out.println("Username: " + username);
            //     System.out.println("Password: " + password);
            // }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Clean up the resources.
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