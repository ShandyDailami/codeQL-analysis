import java.sql.*;

public class java_23954_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            //Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            //Step 2: Prepare a statement
            String query = "SELECT * FROM Employees WHERE salary > ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            //Step 3: Set parameter and execute the query
            preparedStatement.setFloat(1, 5000);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Step 4: Process the result
            while (resultSet.next()) {
                System.out.println("Employee ID: " + resultSet.getInt("id"));
                System.out.println("Employee Name: " + resultSet.getString("name"));
                System.out.println("Employee Salary: " + resultSet.getFloat("salary"));
            }

            //Step 5: Close the connection
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}