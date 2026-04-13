import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_15373_CredentialValidator_A08 {
    private static final String ALGORITHM = "SHA-256";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "password123";
        String hashedPassword = hashPassword(password);

        // Let's say we get a hashed password from a database
        String dbHashedPassword = "hashedPasswordFromDatabase";

        boolean isValid = validatePassword(hashedPassword, dbHashedPassword);
        System.out.println("Is valid: " + isValid);
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
        byte[] hashedPassword = messageDigest.digest(password.getBytes());

        return new String(hashedPassword);
    }

    private static boolean validatePassword(String hashedPassword, String dbHashedPassword) {
        try {
            return hashedPassword.equals(dbHashedPassword);
        } catch (NoSuchAlgorithmException e) {
            // This should not happen, as we're using a known algorithm
            throw new RuntimeException(e);
        }
    }
}