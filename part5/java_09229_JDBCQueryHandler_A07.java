import java.sql.*;

public class java_09229_JDBCQueryHandler_A07 {

    // Method to authenticate user
    public boolean authenticateUser(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, "username", "password");

            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("password");
                return password.equals(dbPassword);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        boolean isAuthenticated = handler.authenticateUser("username", "password");
        System.out.println("Is authenticated: " + isAuthenticated);
    }
}