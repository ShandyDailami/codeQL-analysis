import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_29689_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a Connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a Query
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Step 4: Execute the Query
            pstmt.setString(1, "newuser");
            pstmt.setString(2, "password");
            pstmt.executeUpdate();

            // Step 5: Close the Connection
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}