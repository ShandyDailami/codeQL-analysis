import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Arrays;

public class java_11208_CredentialValidator_A08 {

    private static final String SECRET = "my_secret"; // Secret key

    public static void main(String[] args) {
        String username = "user1";
        String password = "password1";
        String hashedPassword = hashPassword(password);

        if (validateCredentials(username, hashedPassword)) {
            System.out.println("Credentials validated successfully.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private static String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }

    private static boolean validateCredentials(String username, String hashedPassword) {
        return username.equals("user1") && hashedPassword.equals(hashPassword(SECRET));
    }
}