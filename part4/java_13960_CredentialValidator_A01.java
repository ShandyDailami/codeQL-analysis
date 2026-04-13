import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_13960_CredentialValidator_A01 {
    private static final String HARDCODED_PATTERN = "password";

    public static boolean validate(String password) {
        if (password == null) {
            return false;
        }

        // Hash the password using SHA-256
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            // Convert the hash to hexadecimal and compare it to the hard-coded pattern
            String hardCodedPattern = convertToHex(hash);
            return hardCodedPattern.equals(HARDCODED_PATTERN);
        } catch (NoSuchAlgorithmException e) {
            // The requested hash algorithm does not exist.
            return false;
        }
    }

    private static String convertToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}