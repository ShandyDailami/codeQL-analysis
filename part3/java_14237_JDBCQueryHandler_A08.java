import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_14237_JDBCQueryHandler_A08 {

    private Connection conn = null;
    private Statement stmt = null;

    // Connect to the database
    public void connect(String url, String username, String password) {
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Execute a SELECT query
    public ResultSet executeQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Execute a simple INSERT, UPDATE or DELETE query
    public int executeUpdate(String query) {
        try {
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Close the database connection
    public void close() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connect("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        ResultSet result = handler.executeQuery("SELECT * FROM Users");
        while (result.next()) {
            String name = result.getString("name");
            // Handle security-sensitive operations related to integrity failure
            // ...
        }
        handler.close();
    }
}