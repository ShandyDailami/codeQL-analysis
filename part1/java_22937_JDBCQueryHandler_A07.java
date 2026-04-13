import java.sql.*;

public class java_22937_JDBCQueryHandler_A07 {

    public static boolean authenticate(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // Replace with your actual database URL
        String driver = "com.mysql.cj.jdbc.Driver"; // Replace with your actual driver class
        String query = "SELECT * FROM users WHERE username = ? AND password = ?"; // Replace 'users' with your actual table name

        try {
            Class.forName(driver); // Load MySQL Driver

            Connection conn = DriverManager.getConnection(url, "username", "password"); // Replace with your actual username and password

            PreparedStatement pstmt = conn.prepareStatement(query); // Prepare the SQL statement

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery(); // Execute the SQL query

            if (rs.next()) {
                return true; // Authentication successful
            } else {
                return false; // Authentication failed
           
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(authenticate("user1", "password1"));
    }
}