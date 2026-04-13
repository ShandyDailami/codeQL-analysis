import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_32220_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Create a hasher instance
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Obtain a password in plain text
            String input = "password";

            // Obtain the hashed password
            byte[] hashedPassword = md.digest(input.getBytes());

            // Prepare the SQL query
            String sql = "SELECT * FROM Users WHERE password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, new String(hashedPassword));

            // Execute the query
            stmt.executeUpdate();

            // Close the connection
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}