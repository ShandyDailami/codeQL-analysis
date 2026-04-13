import java.sql.*;

public class java_04927_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to the database!");

            // Step 2: Create a statement
            Statement statement = connection.createStatement();
            System.out.println("Statement created!");

            // Step 3: Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employees");
            System.out.println("Query executed!");

            // Step 4: Process the result set
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                int age = resultSet.getInt("Age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Connection closed!");

        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}