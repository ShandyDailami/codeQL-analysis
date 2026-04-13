import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_20585_CredentialValidator_A08 {
    private static final SecureRandom secureRandom = new SecureRandom();

    public String hashPassword(String password) {
        String salt = new String(Base64.getEncoder().encode(getSalt()));
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(password.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] getSalt() {
        return new byte[16];
    }

    public boolean validatePassword(String passwordAttempt, String hashedPassword) {
        return hashPassword(passwordAttempt).equals(hashedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String password = "password";
        String hashedPassword = validator.hashPassword(password);
        System.out.println("Hashed password: " + hashedPassword);
        if (validator.validatePassword(password, hashedPassword)) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is invalid");
        }
    }
}