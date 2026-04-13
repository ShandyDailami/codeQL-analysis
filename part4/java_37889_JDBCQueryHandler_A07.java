import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_37889_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Load the driver for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", DB_USER, DB_PASSWORD);

            // Retrieve the stored hashed password
            String sql = "SELECT password_hash FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, DB_USER);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("password_hash");

                // Compare the hashed input password with the stored hash
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] hashInput = md.digest(DB_PASSWORD.getBytes());

                String generatedHash = bytesToHex(hashInput);

                if (storedHash.equals(generatedHash)) {
                    System.out.println("Login Successful");
                } else {
                    System.out.println("Invalid Password");
                }
            }

            // Close the connection
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        } catch (SQLException e) {
            System.out.println("Error in connection: " + e.getMessage());
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}