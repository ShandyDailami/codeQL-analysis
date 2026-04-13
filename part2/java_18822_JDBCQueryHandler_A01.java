import java.sql.*;

public class java_18822_JDBCQueryHandler_A01 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/testdb";
    
    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    // Constructor to initialize database connection
    public java_18822_JDBCQueryHandler_A01() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a select query
    public ResultSet executeSelectQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if(stmt != null) stmt.close(); } catch(SQLException e){}
            try { if(conn != null) conn.close(); } catch(SQLException e){}
        }
        return rs;
    }

    // Method to execute an update query
    public int executeUpdateQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        int result = 0;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            result = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if(stmt != null) stmt.close(); } catch(SQLException e){}
            try { if(conn != null) conn.close(); } catch(SQLException e){}
        }
        return result;
    }
}