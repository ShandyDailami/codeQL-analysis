import java.sql.*;

public class java_18825_JDBCQueryHandler_A07 {
    public static boolean authenticate(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "password";

        try {
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, user, pass);

            String query = "SELECT * FROM users WHERE username = ?";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("password");
                return password.equals(dbPassword);
            }

            return false;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        boolean isAuthenticated = authenticate("username", "password");
        if (isAuthenticated) {
            System.out.println("User authenticated successfully!");
        } else {
            System.out.println("Authentication failed!");
        }
    }
}