import java.sql.*;

public class java_33742_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement that can execute SQL commands
            Statement statement = connection.createStatement();

            // Step 3: Execute the SQL command to create a new database (if it doesn't already exist)
            statement.execute("CREATE DATABASE IF NOT EXISTS test");

            // Step 4: Switch to the database we just created
            statement.execute("USE test");

            // Step 5: Execute the SQL command to create a new table
            statement.execute("CREATE TABLE IF NOT EXISTS test_table (id INT AUTO_INCREMENT PRIMARY KEY, data VARCHAR(255))");

            // Step 6: Execute the SQL command to insert a row into the table
            statement.execute("INSERT INTO test_table (data) VALUES ('Test data 1')");
            statement.execute("INSERT INTO test_table (data) VALUES ('Test data 2')");
            statement
                    .execute("INSERT INTO test_table (id, data) VALUES (3, 'Test data 3')"); // This will fail because of the primary key constraint

            // Step 7: Close the statement and connection
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}