import java.sql.*;

public class java_33398_JDBCQueryHandler_A01 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        // Step 1: Establish a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {

            // Step 2: Prepare a statement
            String sql = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Step 3: Set the parameter and execute
            pstmt.setString(1, "admin"); // admin is the user name
            ResultSet rs = pstmt.executeQuery();

            // Step 4: Process the result
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("User found: " + username + ", " + password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}