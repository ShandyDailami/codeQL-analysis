import java.sql.*;

public class java_15576_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            connectToDatabase();
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    private static void connectToDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();

        // Example of a query that might fail
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE id = '123'");

        if (resultSet.next()) {
            // If the query was successful, you can perform actions on the result set
            System.out.println("User found: " + resultSet.getString("name"));
        } else {
            // If the query was not successful, you can handle the failure
            int failureCode = resultSet.getInt("failure_code");
            if (failureCode == 101) {
                System.out.println("IntegrityFailure: User with id '123' does not exist");
            } else {
                System.out.println("Other failure: " + failureCode);
            }
        }

        // Always remember to close connections
        connection.close();
    }
}