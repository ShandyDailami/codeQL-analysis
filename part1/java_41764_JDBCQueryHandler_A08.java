import java.sql.*;

public class java_41764_JDBCQueryHandler_A08 {
    // Connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Initialize connection
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Step 2: Prepare SQL statement
            String query = "SELECT * FROM employees WHERE role=?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 3: Set parameter and execute query
            statement.setString(1, "manager");
            ResultSet result = statement.executeQuery();

            // Step 4: Process ResultSet
            while (result.next()) {
                String name = result.getString("name");
                int age = result.getInt("age");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

            // Step 5: Clean up
            result.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}