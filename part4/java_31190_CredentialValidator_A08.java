import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_31190_CredentialValidator_A08 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            // Step 1: Register JDBC driver
            Class.forName(DB_DRIVER);

            // Step 2: Open a connection
            con = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Execute a query
            ps = con.prepareStatement("SELECT * FROM Users WHERE username = ?");
            ps.setString(1, "username");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // If the user exists and the password matches the hashed password in the database
                if (validatePassword(rs.getString("password"), "password")) {
                    System.out.println("Credentials matched!");
                } else {
                    System.out.println("Invalid credentials!");
                }
            } else {
                System.out.println("Invalid username!");
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean validatePassword(String password, String enteredPassword) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Add password bytes to digest
            md.update(enteredPassword.getBytes());

            // Get the hash's bytes 
            byte[] bytes = md.digest();

            // Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password
            String hashedPassword = sb.toString();

            // Compare the hashed password with the password in the database
            return hashedPassword.equals(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}