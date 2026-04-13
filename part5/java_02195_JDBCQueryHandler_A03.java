import java.sql.*;

public class java_02195_JDBCQueryHandler_A03 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);

            // Set parameter
            pstmt.setString(1, "testUser");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("User found!");
            }
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}