import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_33406_CredentialValidator_A01 {
    // This is a simple demonstration, not suitable for real-world use.
    // In a real-world application, you would store the hashed password in the database and compare the hashed password with the hashed version stored in the database.

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException | java.lang.Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static boolean validatePassword(String password, String hashedPassword) {
        return hashPassword(password).equals(hashedPassword);
    }
}