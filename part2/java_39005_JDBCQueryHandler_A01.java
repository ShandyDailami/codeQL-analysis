import java.sql.*;

public class java_39005_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "myusername";
    private static final String password = "mypassword";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static ResultSet executeQuery(String query) {
        Connection conn = getConnection();
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void main(String[] args) {
        String query = "SELECT * FROM users";
        ResultSet rs = executeQuery(query);
        while (rs.next()) {
            String name = rs.getString("name");
            String email = rs.getString("email");
            // process the data
        }
    }
}