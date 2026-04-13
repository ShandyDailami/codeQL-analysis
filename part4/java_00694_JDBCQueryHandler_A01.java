import java.sql.*;

public class java_00694_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a Statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a Query
            String query = "SELECT * FROM employees";
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
            }

            // Step 5: Close the Connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error in query execution: " + e.getMessage());
        }
    }
}