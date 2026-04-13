import java.sql.*;

public class java_15883_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            String query = "SELECT * FROM Users WHERE Username=? AND Password=?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Set parameters
            pstmt.setString(1, "user1");
            pstmt.setString(2, "password1");

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}