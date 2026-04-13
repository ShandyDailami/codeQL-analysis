import java.sql.*;

public class java_27665_JDBCQueryHandler_A07 {
    // This is a JDBC driver name which works with MySQL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    // This is your database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    // This is your username
    private static final String USER = "root";
    // This is your password
    private static final String PASSWORD = "password";

    // Create a connection to the database
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
            System.out.println("Connecting to the database: " + DB_URL);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
        return conn;
    }

    // Execute a SELECT query
    public ResultSet executeQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Execute a INSERT, UPDATE, DELETE query
    public int executeUpdate(String query) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int rows = 0;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(query);
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    // Close the resources
    public void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}