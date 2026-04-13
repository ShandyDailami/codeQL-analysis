import java.sql.*;

public class java_08255_JDBCQueryHandler_A08 {
    // define your database url, username, and password here
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "root";

    private Connection conn = null;
    private Statement stmt = null;

    // open a connection
    public void connect() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }
    }

    // perform a query
    public void performQuery(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("Found: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute query");
            e.printStackTrace();
        }
    }

    // close the connection
    public void close() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Failed to close connection");
            e.printStackTrace();
        }
    }

    // main method for testing
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connect();
        handler.performQuery("SELECT name FROM users WHERE id = 123");
        handler.close();
    }
}