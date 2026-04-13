import java.sql.*;

public class java_28164_JDBCQueryHandler_A08 {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "user";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASS);
            System.out.println("Connected to database!");

            // Step 2: Create a statement
            Statement statement = connection.createStatement();

            // Step 3: Perform operations
            // 3.1: Insert a row
            String insertSQL = "INSERT INTO employees (name, email) VALUES ('John', 'john@example.com')";
            statement.executeUpdate(insertSQL);

            // 3.2: Update a row
            String updateSQL = "UPDATE employees SET email = 'johnny@example.com' WHERE name = 'John'";
            statement.executeUpdate(updateSQL);

            // 3.3: Delete a row
            String deleteSQL = "DELETE FROM employees WHERE name = 'John'";
            statement.executeUpdate(deleteSQL);

            // 3.4: Select a row
            String selectSQL = "SELECT * FROM employees WHERE name = 'John'";
            ResultSet resultSet = statement.executeQuery(selectSQL);

            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));
            }

            // Step 4: Close the connection
            connection.close();
            System.out.println("Connection closed!");

        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}