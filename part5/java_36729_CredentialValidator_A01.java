import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_36729_CredentialValidator_A01 {
    // Assuming passwords are stored as a hash of their corresponding values.
    private static String[] passwords = {
        "8c69eab58f0c72b964f2437a0f8b898488e84d2", // password1
        "9f8e9c5a550f87279846641e7847e77c98f5d8e" // password2
    };

    // A method to validate a password.
    public boolean validatePassword(String attempt) throws NoSuchAlgorithmException {
        // The attempt is hashed.
        String attemptHash = hashPassword(attempt);

        // If the hashed attempt matches a stored password, then the attempt is valid.
        for (String storedPassword : passwords) {
            if (storedPassword.equals(attemptHash)) {
                return true;
            }
        }

        return false;
    }

    // A utility method to hash a password.
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes("UTF-8"));
        return bytesToHex(hash);
    }

    // A utility method to convert a byte array to a hex string.
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}