import java.sql.*;

public class java_33587_JDBCQueryHandler_A07 {

    private Connection conn = null;

    public void createUser(String username, String password) {
        try {
            // Step 1: Establish a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username", "password");

            // Step 2: Create a new user
            String SQL = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();

            // Step 3: Close the connection
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error in creating user");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.createUser("testuser", "testpassword");
    }
}