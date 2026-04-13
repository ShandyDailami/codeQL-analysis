import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_19113_JDBCQueryHandler_A03 {

    private static Connection conn;
    private static Statement stmt;

    static {
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");

            // Create a statement object
            stmt = conn.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Static method to execute a SELECT query
    public static ResultSet executeSelectQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // Static method to execute an INSERT, UPDATE or DELETE query
    public static int executeUpdateQuery(String query) {
        try {
            return stmt.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
}