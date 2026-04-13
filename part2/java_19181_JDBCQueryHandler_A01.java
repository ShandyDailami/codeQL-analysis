import java.sql.*;

public class java_19181_JDBCQueryHandler_A01 {

    // Define the database URL, user, and password here
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Execute a query
            String sql = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "testUser"); // Test with a known user
            ResultSet rs = pstmt.executeQuery();

            // Step 3: Process the result
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 4: Close the connection
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}