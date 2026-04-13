import java.sql.*;

public class java_07450_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a statement
            statement = connection.createStatement();

            // Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees WHERE id = '" + args[0] + "'");

            while (resultSet.next()) {
                System.out.println("Found employee: " + resultSet.getString("name"));
            }

            // Close the statement and connection
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}