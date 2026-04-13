import java.sql.*;

public class java_14459_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create a Statement
            Statement statement = connection.createStatement();

            // Step 4: Execute a Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employees");

            // Step 5: Process the ResultSet
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                System.out.println("Name: " + name + ", Salary: " + salary);
            }

            // Step 6: Close the Connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}