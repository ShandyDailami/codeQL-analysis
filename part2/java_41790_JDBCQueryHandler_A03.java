import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_41790_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // assuming MySQL JDBC driver

            // Step 2: Establish a connection to the database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase", // replace with your connection details
                    "username", // replace with your username
                    "password"); // replace with your password

            // Step 3: Execute a SQL query
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM employees WHERE salary > " + connection.prepareStatement("SELECT MAX(salary) FROM employees");
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 4: Process the results
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
            }

            // Step 5: Close the connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}