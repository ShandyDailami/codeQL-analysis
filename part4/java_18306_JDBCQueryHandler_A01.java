import java.sql.*;

public class java_18306_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Register a Driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Step 2: Establish a Connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Execute a Query
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM employees WHERE role='Admin'";
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Handle the ResultSet
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Step 5: Close the Connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}