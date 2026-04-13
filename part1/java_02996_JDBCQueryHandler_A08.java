import java.sql.*;

public class java_02996_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try {
            // Step 1: Get a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement object
            Statement statement = connection.createStatement();

            // Step 3: Execute a SQL query
            String sql = "INSERT INTO Users (username, password) VALUES ('newuser', 'newpassword')";
            statement.executeUpdate(sql);

            // Step 4: Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}