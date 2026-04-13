import java.sql.*;

public class java_06233_JDBCQueryHandler_A08 {

    private Connection connection;
    private Statement statement;

    public java_06233_JDBCQueryHandler_A08(String url, String username, String password) {
        try {
            // Create a connection
            this.connection = DriverManager.getConnection(url, username, password);
            // Create a statement
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            // Execute the query
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            // Execute the update
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void closeConnection() {
        try {
            // Close the connection
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Initialize the JDBCQueryHandler
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");

        // Example of executing a query
        ResultSet result = handler.executeQuery("SELECT * FROM users");
        while (result.next()) {
            System.out.println(result.getString("username"));
        }

        // Example of executing an update
        int rowsAffected = handler.executeUpdate("UPDATE users SET email='newemail@example.com' WHERE username='username'");
        System.out.println("Number of rows updated: " + rowsAffected);

        // Close the connection
        handler.closeConnection();
    }
}