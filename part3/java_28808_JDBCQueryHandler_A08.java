import java.sql.*;

public class java_28808_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            // Step 2: Create a statement
            Statement statement = connection.createStatement();
            // Step 3: Execute a query
            String query = "SELECT * FROM employees WHERE id = " + 1;
            ResultSet resultSet = statement.executeQuery(query);
            // Step 4: Handle the results
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println("Name: " + name);
            }
            // Step 5: Clean up
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}