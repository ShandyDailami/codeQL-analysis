import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_06436_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String user = "your_username";
        String password = "your_password";

        try {
            // Step 1: Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password");

            // Step 2: Prepare the SQL query
            PreparedStatement statement = connection.prepareStatement("SELECT password FROM users WHERE username = ?");
            statement.setString(1, user);

            // Step 3: Execute the query and get the result
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                // Step 4: Compare the inputted password with the hashed password in the database
                String hashedPassword = result.getString("password");
                if (isPasswordValid(password, hashedPassword)) {
                    System.out.println("Access granted!");
                } else {
                    System.out.println("Access denied!");
                }
            } else {
                System.out.println("User not found!");
            }

            // Step 5: Close the connection
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to hash passwords
    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return new String(hash);
    }

    // Helper method to validate passwords
    private static boolean isPasswordValid(String enteredPassword, String hashedPassword) {
        try {
            return hashedPassword.equals(hashPassword(enteredPassword));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}