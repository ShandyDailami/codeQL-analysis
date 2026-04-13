import java.sql.*;

public class java_38638_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "invalidUser");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String passwordInDB = rs.getString("password");
                if (!BCrypt.checkpw("invalidPassword", passwordInDB)) {
                    System.out.println("Authentication failure.");
                } else {
                    System.out.println("Authentication success.");
                }
            } else {
                System.out.println("No user found with that username.");
            }

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}