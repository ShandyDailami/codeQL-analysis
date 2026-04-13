import java.sql.*;

public class java_25057_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a new connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a new statement
            Statement statement = connection.createStatement();

            // SQL query
            String sql = "INSERT INTO users (username, password) VALUES ('testuser', 'testpassword')";

            // Execute the SQL query
            statement.executeUpdate(sql);

            // Close the connection
            statement.close();
            connection.close();

            System.out.println("User inserted successfully!");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}