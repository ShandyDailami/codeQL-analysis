import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_25426_JDBCQueryHandler_A08 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Prepare a statement
            String SQL = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = con.prepareStatement(SQL);

            // Step 3: Hash the user's password
            String passwordToHash = "password"; // Assume this is the password of the user
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedPassword = md.digest(passwordToHash.getBytes());

            // Step 4: Insert the user into the database
            pstmt.setString(1, "user");
            pstmt.setBytes(2, hashedPassword);
            pstmt.executeUpdate();

            // Step 5: Close the connection
            pstmt.close();
            con.close();
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}