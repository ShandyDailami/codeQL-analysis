import java.sql.*;

public class java_07736_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            // Step 4: Process the results
            while (resultSet.next()) {
                System.out.println("Employee ID: " + resultSet.getInt("id"));
                System.out.println("Employee Name: " + resultSet.getString("name"));
           .
            .
            .
            // More code here...

            // Step 6: Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting or executing the query: " + e.getMessage());
        }
    }
}