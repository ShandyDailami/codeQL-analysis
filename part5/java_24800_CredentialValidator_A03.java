import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_24800_CredentialValidator_A03 {
    private static final String STRONG_PASSWORD_PREFIX = "$$StrongPassword$$";

    public static enum PasswordStrength {
        WEAK, MEDIUM, STRONG
    }

    public PasswordStrength checkPasswordStrength(String password) {
        if (password.length() < 8) {
            return PasswordStrength.WEAK;
        } else if (password.contains(STRONG_PASSWORD_PREFIX)) {
            return PasswordStrength.STRONG;
        } else {
            return PasswordStrength.MEDIUM;
        }
    }

    public boolean validate(String password, String hashedPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            String hashedPasswordStr = bytesToHex(hashedBytes);

            if (hashedPasswordStr.equals(hashedPassword)) {
                return true;
            } else {
                return false;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}