import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_12076_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:your-database-url";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // The hashing algorithm to use
        String algorithm = "SHA-256";

        // Create a connection to the database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        // Perform a security-sensitive operation (password hashing)
        String password = "your-password";
        String hashedPassword = hashPassword(password, algorithm);

        // Print the hashed password
        System.out.println("Hashed password: " + hashedPassword);

        // Close the connection
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String hashPassword(String password, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] hashedPassword = md.digest(password.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}