import java.sql.*;

public class java_13484_JDBCQueryHandler_A08 {

    private Connection connection;
    private Statement statement;

    // Constructor
    public java_13484_JDBCQueryHandler_A08(String dbURL, String user, String password) {
        try {
            connection = DriverManager.getConnection(dbURL, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute queries
    public ResultSet executeQuery(String query) {
        ResultSet result = null;
        try {
            result = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Method to execute updates
    public int executeUpdate(String query) {
        int count = 0;
        try {
            count = statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    // Main method
    public static void main(String[] args) {
        // Provide your own database URL, username and password
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testDB", "root", "password");

        // Example query
        ResultSet result = handler.executeQuery("SELECT * FROM users WHERE role='ADMIN'");

        // Printing the result
        try {
            while (result.next()) {
                System.out.println("User ID: " + result.getInt("id"));
                System.out.println("User Name: " + result.getString("name"));
                System.out.println("User Role: " + result.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}