import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_23035_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        Connection connection = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            // Perform SQL operations here
            // Example: Insert, Update, Delete, Select
            String sql = "INSERT INTO test_table (id, name) VALUES (1, 'John')";
            connection.createStatement().executeUpdate(sql);

            // Close the connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}