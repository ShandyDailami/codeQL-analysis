import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_21281_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create a statement
            Statement statement = connection.createStatement();

            // Step 4: Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT password FROM users WHERE username = 'myuser'");

            if (resultSet.next()) {
                String password = resultSet.getString("password");

                // Step 5: Hash the password using SHA-256
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] passwordBytes = md.digest(password.getBytes());
                String hashedPassword = bytesToHex(passwordBytes);

                // Step 6: Compare the hashed password with the stored hash
                if (hashedPassword.equals(storedHashedPassword)) {
                    System.out.println("Authentication successful!");
                } else {
                    System.out.println("Authentication failed!");
                }
            }

            // Step 7: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert byte array to hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}