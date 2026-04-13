import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_11005_CredentialValidator_A08 {

    // This is a method to check if a password is strong enough.
    // A strong password is at least 8 characters long and contains at least one uppercase letter, one lowercase letter, one special character, and one digit.
    public boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            return false;
        }
        if (password.length() < 8) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        if (!password.matches(".*[#$%&'.()*+,-./].*")) {
            return false;
        }
        return true;
    }

    // This is a method to hash a password using SHA-256.
    public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return bytesToHex(hash);
    }

    // This is a helper method to convert a byte array to a hexadecimal string.
    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

    // This is a method to validate a password.
    // It first checks if the password is strong enough, then hashes the password.
    public boolean validatePassword(String password) {
        if (isPasswordStrongEnough(password)) {
            try {
                return hashPassword(password).equals(hashPassword(password));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}