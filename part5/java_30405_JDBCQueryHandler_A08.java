import java.sql.*;

public class java_30405_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Create a statement
            statement = connection.createStatement();

            // Create a query
            String query = "SELECT * FROM Employee WHERE Salary > 50000";

            // Execute the query
            resultSet = statement.executeQuery(query);

            // Handle the result set
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                int salary = resultSet.getInt("Salary");
                System.out.println("Name: " + name + ", Salary: " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connections
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}