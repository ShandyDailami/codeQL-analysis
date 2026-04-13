import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_20441_CredentialValidator_A08 {

    // Method to hash password
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes());
        return bytesToHex(hash);
    }

    // Method to convert byte array to hexadecimal
    private String bytesToHex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) {
            hex.append(String.format("%02X", b));
        }
        return hex.toString();
    }

    // Method to validate user
    public boolean validateUser(String inputPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidParameterException {
        if (storedPassword == null || storedPassword.isEmpty()) {
            throw new InvalidParameterException("Stored password cannot be null or empty");
        }
        String hashedPassword = hashPassword(inputPassword);
        return hashedPassword.equals(storedPassword);
    }
}