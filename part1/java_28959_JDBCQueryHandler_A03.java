import java.sql.*;

public class java_28959_JDBCQueryHandler_A03 {
    // DB credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;
    private Statement statement;

    // Establish the connection
    public java_28959_JDBCQueryHandler_A03() {
        try {
            this.connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Execute a SELECT query
    public ResultSet executeQuery(String query) {
        try {
            return this.statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Execute a INSERT, UPDATE or DELETE query
    public int executeUpdate(String query) {
        try {
            return this.statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Close the connection
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        // Execute a SELECT query
        ResultSet result = handler.executeQuery("SELECT * FROM users");
        while (result.next()) {
            System.out.println(result.getString("name"));
        }

        // Execute a INSERT query
        handler.executeUpdate("INSERT INTO users (name) VALUES ('John')");

        // Execute a UPDATE query
        handler.executeUpdate("UPDATE users SET name = 'Jane' WHERE name = 'John'");

        // Execute a DELETE query
        handler.executeUpdate("DELETE FROM users WHERE name = 'Jane'");

        handler.close();
    }
}