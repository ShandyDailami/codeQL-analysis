import java.sql.*;
import java.util.logging.*;

public class java_10581_JDBCQueryHandler_A07 {
    private static Logger logger = Logger.getLogger(JDBCQueryHandler.class.getName());

    public static Connection createConnection(String databaseUrl, String user, String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(databaseUrl, user, password);
        } catch (SQLException e) {
            logger.severe("Cannot create connection to database: " + e.getMessage());
        }
        return conn;
    }

    public static ResultSet executeQuery(Connection conn, String query) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            logger.severe("Cannot execute query: " + e.getMessage());
        }
        return rs;
    }

    public static void main(String[] args) {
        String databaseUrl = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "myuser";
        String password = "mypassword";

        Connection conn = createConnection(databaseUrl, user, password);
        ResultSet rs = executeQuery(conn, "SELECT * FROM mytable");

        // Process the ResultSet here
    }
}