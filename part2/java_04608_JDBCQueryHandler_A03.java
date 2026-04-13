import java.sql.*;

public class java_04608_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees WHERE salary > 50000");

            // Step 4: Process the result set
            while (resultSet.next()) {
                String employeeName = resultSet.getString("name");
                double employeeSalary = resultSet.getDouble("salary");

                System.out.println("Name: " + employeeName);
                System.out.println("Salary: " + employeeSalary);
            }

            // Step 5: Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}