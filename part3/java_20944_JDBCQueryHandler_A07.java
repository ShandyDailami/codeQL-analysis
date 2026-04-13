import java.sql.*;

public class java_20944_JDBCQueryHandler_A07 {

    public boolean login(String username, String password) {
        // Establish a database connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        String driver = "com.mysql.jdbc.Driver";
        String user = "username";
        String pwd = "password";

        try (Connection con = DriverManager.getConnection(url, user, pwd)) {
            // Prepare a statement
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            // Set the input parameters
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // User found in the database
                return true;
            } else {
                // User not found
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        boolean loginSuccess = handler.login("user1", "password");
        System.out.println("Login Success: " + loginSuccess);
    }
}