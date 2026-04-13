import java.sql.*;

public class java_27280_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, "testUser"); // Replace "testUser" with the username you want to check
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}