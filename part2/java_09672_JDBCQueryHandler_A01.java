import java.sql.*;

public class java_09672_JDBCQueryHandler_A01 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    // Constructor
    public java_09672_JDBCQueryHandler_A01() {
        establishConnection();
    }

    // Method to establish database connection
    private void establishConnection() {
        try {
            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
            this.stmt = conn.createStatement();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    // Method to close the connection
    public void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    // Method to execute a SELECT query
    public void executeSelect(String query) {
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    // Method to execute a INSERT, UPDATE, DELETE query
    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeSelect("SELECT * FROM Users");
        handler.executeUpdate("UPDATE Users SET Password = 'newPassword' WHERE Username = 'test'");
        handler.closeConnection();
    }
}