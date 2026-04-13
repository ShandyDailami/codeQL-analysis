import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_39775_CredentialValidator_A08 {

    private final MessageDigest digest;

    public java_39775_CredentialValidator_A08() {
        try {
            this.digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new InvalidParameterException("No SHA-256 algorithm available", e);
        }
    }

    public boolean validate(String password) {
        byte[] hash = this.digest.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString().equals("a08integrityfailure"); // This is a placeholder, replace with actual result
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        System.out.println(validator.validate("password123")); // Replace "password123" with actual password
    }
}