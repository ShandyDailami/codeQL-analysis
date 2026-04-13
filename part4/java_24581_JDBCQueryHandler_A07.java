import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_24581_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myUser";
        String password = "myPassword";

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a SQL statement
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set parameters
            pstmt.setString(1, "newUser");
            pstmt.setString(2, "newPassword");

            // Step 4: Execute the SQL statement
            pstmt.executeUpdate();

            // Step 5: Close resources
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}