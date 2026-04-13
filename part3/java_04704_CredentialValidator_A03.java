import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_04704_CredentialValidator_A03 {

    public static void main(String[] args) {
        String username = "testuser";
        String password = "password";
        String hashedPassword = hashPassword(password);

        if (validateCredentials(username, hashedPassword)) {
            System.out.println("Credentials validated successfully!");
        } else {
            System.out.println("Credentials invalid!");
        }
    }

    private static String hashPassword(String password) {
        String hashedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            hashedPassword = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPassword;
    }

    private static boolean validateCredentials(String username, String hashedPassword) {
        // This method should connect to a database to fetch the hashed password for the given username
        // You can use an in-memory database for this purpose, or a real database.
        // For the purpose of this example, we'll just return true for the username "testuser" and the hashed password "password".
        return username.equals("testuser") && hashedPassword.equals(hashPassword("password"));
    }
}