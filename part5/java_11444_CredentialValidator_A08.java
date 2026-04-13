import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_11444_CredentialValidator_A08 {
    private static final String ALGORITHM = "SHA-256";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        CredentialValidator validator = new CredentialValidator();

        // Create a random password
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        // Create a password
        String password = "password";

        // Hash the password with a salt
        MessageDigest md = MessageDigest.getInstance(ALGORITHM);
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes());

        // Print the salt and the hashed password
        System.out.println("Salt: " + Base64.getEncoder().encodeToString(salt));
        System.out.println("Hashed password: " + Base64.getEncoder().encodeToString(hashedPassword));

        // Now, let's validate the password
        System.out.println("Enter password to validate: ");
        String enteredPassword = System.console().readLine();

        MessageDigest md2 = MessageDigest.getInstance(ALGORITHM);
        md2.update(salt);
        byte[] enteredPasswordHash = md2.digest(enteredPassword.getBytes());

        if (compareHashes(hashedPassword, enteredPasswordHash)) {
            System.out.println("Password is correct.");
        } else {
            System.out.println("Password is incorrect.");
        }
    }

    private static boolean compareHashes(byte[] hash1, byte[] hash2) {
        if (hash1.length != hash2.length) {
            return false;
        }

        for (int i = 0; i < hash1.length; i++) {
            if (hash1[i] != hash2[i]) {
                return false;
            }
        }

        return true;
    }
}