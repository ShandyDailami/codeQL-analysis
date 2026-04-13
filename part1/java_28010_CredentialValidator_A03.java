import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_28010_CredentialValidator_A03 {
    private static final String STRONG_PASSWORD = "ThisPasswordShouldBeStrong";

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate(validator.hashPassword(STRONG_PASSWORD));
    }

    public boolean validate(String hashedPassword) {
        String realPassword = hashPassword(STRONG_PASSWORD);
        return realPassword.equals(hashedPassword);
    }

    private String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException | java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(String.format("%02X", bytes[i]));
        }
        return sb.toString();
    }
}