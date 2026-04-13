import java.sql.*;

public class java_29963_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "newuser");
            pstmt.setString(2, "password");
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully.");
            } else {
                System.out.println("Failed to insert the new user.");
            }

            // Retrieve the inserted user
            ResultSet rs = pstmt.executeQuery("SELECT * FROM users WHERE username = ?");

            while (rs.next()) {
                String usernameRetrieved = rs.getString("username");
                String passwordRetrieved = rs.getString("password");
                System.out.println("Username: " + usernameRetrieved);
                System.out.println("Password: " + passwordRetrieved);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e);
        }
    }
}