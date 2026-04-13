import java.sql.*;

public class java_32261_JDBCQueryHandler_A08 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                String query = "SELECT * FROM Users WHERE username=?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, "testuser");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    System.out.println("User: " + username + ", Password: " + password);
                }
                rs.close();
                pstmt.close();
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            return null;
        }
    }
}