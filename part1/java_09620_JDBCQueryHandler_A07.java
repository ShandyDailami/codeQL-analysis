import java.sql.*;

public class java_09620_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Step 1: Set up database connection
        String url = "jdbc:your_database_url";
        String username = "username";
        String password = "password";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        // Step 2: Execute SQL query to fetch password
        String sql = "SELECT password FROM your_table_name WHERE username = ?";
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "username"); // replace with actual username

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");

                // Step 3: Compare input password with stored password
                String inputPassword = "input_password"; // replace with actual password

                if (inputPassword.equals(storedPassword)) {
                    System.out.println("Authentication successful!");
                } else {
                    System.out.println("Authentication failed!");
                }
            } else {
                System.out.println("User not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 4: Close database connection
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}