import java.sql.*;

public class java_02715_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DB_USER = "username";
    private static final String DB_PASS = "password";

    // Database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/database_name";

    // Create a connection to the database
    public Connection createConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Execute a query on the connection
    public void executeQuery(Connection conn, String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method to test the code
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        Connection conn = handler.createConnection();
        handler.executeQuery(conn, "SELECT * FROM table_name");
    }
}