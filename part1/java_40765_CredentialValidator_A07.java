import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_40765_CredentialValidator_A07 {

    // Pre-defined hashes for users
    private static final String USER1_HASH = "5e88479d0509b22529bab42e2840fade99"; // hash of 'password'
    private static final String USER2_HASH = "fe2ceada2f1591e967f4f257c7f8ec676"; // hash of 'java'

    // Method to hash a password
    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return bytesToHex(hash);
    }

    // Method to convert bytes to hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    // Method to validate a password
    public boolean validate(String user, String password) throws NoSuchAlgorithmException {
        if(user.equals("user1")) {
            return hashPassword(password).equals(USER1_HASH);
        } else if(user.equals("user2")) {
            return hashPassword(password).equals(USER2_HASH);
        } else {
            throw new IllegalArgumentException("Invalid user");
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        validator.validate("user1", "password"); // should return true
        validator.validate("user2", "java"); // should return true
        validator.validate("user2", "wrong_password"); // should return false
    }
}