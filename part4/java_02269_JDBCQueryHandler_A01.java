import java.sql.*;

public class java_02269_JDBCQueryHandler_A01 {
    // Driver name and database URL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/testdb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    // Constructor
    public java_02269_JDBCQueryHandler_A01() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Returns a connection to the database
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Executes a SELECT query
    public ResultSet executeSelectQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try { if(rs != null) rs.close(); } catch(SQLException e) {}
            try { if(stmt != null) stmt.close(); } catch(SQLException e) {}
            try { if(conn != null) conn.close(); } catch(SQLException e) {}
        }
        return rs;
    }

    // Executes a DELETE, UPDATE or INSERT query
    public int executeUpdateQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        int rows = 0;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rows = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try { if(stmt != null) stmt.close(); } catch(SQLException e) {}
            try { if(conn != null) conn.close(); } catch(SQLException e) {}
        }
        return rows;
    }
}