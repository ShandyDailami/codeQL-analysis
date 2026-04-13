import java.sql.*;

public class java_23469_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table");

            while (resultSet.next()) {
                // Access Control: Breaking access to the table
                String column1 = resultSet.getString("column1");
                // Access Control: Breaking access to the column

                // Process the data
                System.out.println("column1: " + column1);
            }

            // Close the statement and connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error in JDBC operation: " + e.getMessage());
        }
    }
}