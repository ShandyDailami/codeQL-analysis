import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_04355_CredentialValidator_A08 {
    public static boolean validate(String password) {
        String hashedPassword = hashPassword(password);

        // Hardcoded hash for example purposes.
        String hardcodedPasswordHash = "$2a$10$ECEE.587.8511.2171.45755.4565.2831.7832.7328.4276.8866.8966";

        return hashedPassword.equals(hardcodedPasswordHash);
    }

    private static String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = md.digest(password.getBytes());
        return bytesToHex(hash);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}