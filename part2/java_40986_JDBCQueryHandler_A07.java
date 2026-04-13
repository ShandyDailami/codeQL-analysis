import java.sql.*;

public class java_40986_JDBCQueryHandler_A07 {
    public static boolean login(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/mydatabase"; // change this to your database URL
        String driver = "com.mysql.cj.jdbc.Driver"; // change this to your MySQL driver

        try {
            Class.forName(driver);

            // Create a new connection
            Connection conn = DriverManager.getConnection(url, "username", "password");

            // Prepare the SQL statement
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set the parameters
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(login("user", "pass"));
    }
}