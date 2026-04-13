import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_33999_CredentialValidator_A08 {

    private String correctPassword;

    public java_33999_CredentialValidator_A08(String correctPassword) {
        this.correctPassword = correctPassword;
    }

    public boolean validate(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        String passwordHash = sb.toString();
        return passwordHash.equals(correctPassword);
    }
}