import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_29935_CredentialValidator_A07 {
    // In a real-world application, this would be stored in a database
    private static final String SALT = "ThisIsASalt";

    public boolean validate(String passwordAttempt, String hashedPassword) {
        String hashedAttempt = hashPassword(passwordAttempt, SALT);
        return hashedAttempt.equals(hashedPassword);
    }

    private String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            String generatedPassword = sb.toString();
            return generatedPassword;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String hashedPassword = validator.hashPassword("password", "ThisIsASalt");
        System.out.println(hashedPassword);
        boolean isValid = validator.validate("password", hashedPassword);
        System.out.println(isValid);
    }
}