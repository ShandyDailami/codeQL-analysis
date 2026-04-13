import java.sql.*;

public class java_04818_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, 123); // Set the user id to delete

            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully");
            } else {
                System.out.println("No user to delete");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}