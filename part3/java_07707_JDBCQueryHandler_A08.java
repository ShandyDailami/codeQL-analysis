import java.sql.*;

public class java_07707_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn = null;

    public java_07707_JDBCQueryHandler_A08() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void integrityFailureExample() {
        try {
            String query = "SELECT * FROM Users WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Here, we're using a hardcoded ID for simplicity, in a real application
            // this would be coming from an incoming request
            pstmt.setInt(1, 1);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // do something with the rs
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new JDBCQueryHandler().integrityFailureExample();
    }
}