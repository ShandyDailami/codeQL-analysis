import java.sql.*;

public class java_23366_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "myusername";
    private static final String password = "mypassword";
    private static Connection conn = null;

    public static void main(String[] args) {
        String query = "SELECT * FROM Users WHERE username = ?";
        try {
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "testUser"); // use real user
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("password"));
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }
}