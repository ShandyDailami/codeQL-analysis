import java.sql.*;

public class java_02173_JDBCQueryHandler_A08 {

    // The database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    // A method to handle security-sensitive operations
    public void handleSecurityOperations() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            // Open a statement
            try (Statement statement = connection.createStatement()) {
                // Execute a SQL query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM my_table");

                while (resultSet.next()) {
                    // Handle the result set here
                    // For example, print out the result
                    System.out.println("Found a row: " + resultSet.getString("my_column"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.handleSecurityOperations();
    }
}