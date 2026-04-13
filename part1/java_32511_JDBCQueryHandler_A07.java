import java.sql.*;

public class java_32511_JDBCQueryHandler_A07 {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static void main(String[] args) {
        try {
            connectDB();
            runQuery();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            disconnectDB();
        }
    }

    private static void connectDB() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
    }

    private static void disconnectDB() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void runQuery() throws SQLException {
        String sql = "SELECT * FROM USERS WHERE AGE = 25 AND NAME = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "John");
        rs = pstmt.executeQuery();

        while (rs.next()) {
            String name = rs.getString("NAME");
            int age = rs.getInt("AGE");
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }
}