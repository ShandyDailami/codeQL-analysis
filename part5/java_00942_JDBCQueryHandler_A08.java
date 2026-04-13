import java.sql.*;

public class java_00942_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "myusername";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);

            // Assuming password is strong enough to be inserted into the database
            pstmt.setString(1, "newUser");
            pstmt.setString(2, "strongPassword");
            pstmt.executeUpdate();

            System.out.println("User inserted successfully");

            conn.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database");
            e.printStackTrace();
        }
    }
}