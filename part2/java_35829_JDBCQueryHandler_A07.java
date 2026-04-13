import java.sql.*;

public class java_35829_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "myuser";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(url, username, password);

            String selectQuery = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement pstmt = con.prepareStatement(selectQuery);
            pstmt.setString(1, "testUser");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            con.close();

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}