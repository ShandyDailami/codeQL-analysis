import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_26217_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Establish the connection
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create a new statement
            try (Statement statement = connection.createStatement()) {
                // Execute the query
                String sql = "SELECT * FROM Users";
                statement.executeUpdate(sql);

                // Handle the results
                ResultSet resultSet = statement.getResultSet();

                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}