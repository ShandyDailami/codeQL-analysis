import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_39720_JDBCQueryHandler_A07 {

    private static Connection conn;
    private static Statement stmt;

    // Load driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // replace with actual driver
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("Could not load JDBC driver");
        }
    }

    // Establish the database connection
    private static void establishConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "username", "password"); // replace with actual database connection info
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new ExceptionInInitializerError("Could not establish connection to database");
        }
    }

    // Execute a query and get the ResultSet
    public ResultSet executeQuery(String query) {
        establishConnection();
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new ExceptionInInitializerError("Could not execute query");
        }
    }

    // Close connection and statement
    public void closeConnection() {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new ExceptionInInitializerError("Could not close connection to database");
        }
    }
}