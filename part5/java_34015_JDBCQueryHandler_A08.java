import java.sql.*;

public class java_34015_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Register MySQL driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Step 2: Establish connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Execute SQL query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE name = 'John'");

            // Step 4: Process results
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
           
                // Step 5: Security-related operations
                if (name.equals("John") && age == 30) {
                    System.out.println("Access granted!");
                } else {
                    System.out.println("Access denied!");
                }
            }

            // Step 6: Close connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}