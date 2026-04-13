import java.sql.*;

public class java_03543_SessionManager_A03 {
    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public java_03543_SessionManager_A03() {
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "user", "password");

            // Create a statement object
            stmt = conn.createStatement();

            // Prepare SQL query to create a new user
            String sql = "INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?,?)";
            pstmt = conn.prepareStatement(sql);

            // Execute the SQL query
            pstmt.setString(1, "testuser");
            pstmt.setString(2, "testpassword");
            pstmt.executeUpdate();

            // Close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SessionManager();
    }
}