import java.sql.*;

public class java_00482_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
       
            // This will never happen as DriverManager.getConnection() will never throw a SQLException
            System.exit(1);
        }
        return conn;
    }

    public static ResultSet executeQuery(String query) {
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void main(String[] args) {
        String query = "SELECT * FROM employees";
        ResultSet rs = executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
    }
}