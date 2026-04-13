import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_13518_CredentialValidator_A03 {

    public static void main(String[] args) {
        String username = "user";
        String password = "password";
        String hashedPassword = hashPassword(password);

        if (validateUser(username, hashedPassword)) {
            System.out.println("Credentials valid.");
        } else {
            System.out.println("Credentials invalid.");
        }
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static boolean validateUser(String username, String hashedPassword) {
        // This is a placeholder for the actual implementation,
        // it should actually compare the hashed password with the stored one.
        return username.equals("user") && hashedPassword.equals(hashPassword("password"));
    }
}