import java.sql.*;

public class java_12584_JDBCQueryHandler_A01 {

    // private instance variables for database connection
    private Connection connection = null;
    private Statement statement = null;

    // constructor
    public java_12584_JDBCQueryHandler_A01() {
        // Initialize database connection
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username", "password");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // method to perform a security-sensitive operation
    public void performSecuritySensitiveOperation() {
        // Create a query to select all records from a table
        String query = "SELECT * FROM test_table";
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);

            // Print all records
            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
       
        } finally {
            // Close the statement and connection
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

    // main method
    public static void main(String[] args) {
        VanillaJDBCQueryHandler vjdh = new VanillaJDBCQueryHandler();
        vjdh.performSecuritySensitiveOperation();
    }
}