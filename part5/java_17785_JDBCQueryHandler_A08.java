import java.sql.*;

public class java_17785_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            // Process the results
            while (resultSet.next()) {
                String employeeName = resultSet.getString("employeeName");
                int employeeAge = resultSet.getInt("employeeAge");
                String employeeDepartment = resultSet.getString("employeeDepartment");

                System.out.println("Employee Name: " + employeeName);
                System.out.println("Employee Age: " + employeeAge);
                System.out.println("Employee Department: " + employeeDepartment);
            }

            // Close the connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}