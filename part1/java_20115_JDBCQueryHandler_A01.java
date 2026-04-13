import java.sql.*;

public class java_20115_JDBCQueryHandler_A01 {

    // Database credentials
    private static final String DB_USER = "username";
    private static final String DB_PASS = "password";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Connection established.");

            // Step 2: Perform a query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM my_table");

            // Step 3: Process the result
            while (resultSet.next()) {
                System.out.println("Row: " + resultSet.getString("column_name"));
            }

            // Step 4: Close the connection
            connection.close();
            System.out.println("Connection closed.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}