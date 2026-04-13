import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_03147_CredentialValidator_A03 {
    public static final String USERNAME_TO_VALIDATE = "testuser";
    public static final String PASSWORD_TO_VALIDATE = "password";

    public static void main(String[] args) {
        String hashedPassword = hashPassword("password");

        if (validateCredentials(USERNAME_TO_VALIDATE, hashedPassword)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean validateCredentials(String username, String hashedPassword) {
        // In a real-world application, you would compare the hashed password to a stored password.
        // This is a simplified example.
        return username.equals(USERNAME_TO_VALIDATE) && hashedPassword.equals(hashedPassword);
    }
}