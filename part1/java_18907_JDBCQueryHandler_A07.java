import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_18907_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Create a statement
            String sql = "SELECT password FROM Users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set the username
            pstmt.setString(1, "testUser");

            // Execute the statement and get the result set
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Get the hashed password from the result set
                byte[] hashedPassword = rs.getBytes("password");

                // Generate a salt
                SecureRandom sr = new SecureRandom();
                byte[] salt = new byte[16];
                sr.nextBytes(salt);

                // Hash the password with the salt
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(salt);
                byte[] hashedInputPassword = md.digest(PASSWORD.getBytes());

                // Compare the hashed passwords
                if (Arrays.equals(hashedInputPassword, hashedPassword)) {
                    System.out.println("Password is correct");
                } else {
                    System.out.println("Password is incorrect");
                }
            }

            // Close the connection
            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}