import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_30192_CredentialValidator_A08 {

    // Hashing algorithm
    private static final MessageDigest digest = MessageDigest.getInstance("SHA-256");

    public static String hashPassword(String password, SecureRandom random) throws NoSuchAlgorithmException {
        byte[] hash = digest.digest(password.getBytes());

        // Convert the hash to hex string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public static boolean validatePassword(String password, String hashedPassword) throws NoSuchAlgorithmException {
        return hashedPassword.equals(hashPassword(password, new SecureRandom()));
    }
}