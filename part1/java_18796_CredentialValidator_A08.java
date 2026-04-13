import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_18796_CredentialValidator_A08 {

    private MessageDigest md;

    public java_18796_CredentialValidator_A08() {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String hashPassword(String password) {
        byte[] hashByte = md.digest(password.getBytes());
        String hash = Base64.getEncoder().encodeToString(hashByte);
        return hash;
    }

    public boolean verifyPassword(String password, String hashedPassword) {
        return hashPassword(password).equals(hashedPassword);
    }

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();

        String password = "myPassword";
        String hashedPassword = validator.hashPassword(password);

        System.out.println("Hashed Password: " + hashedPassword);

        boolean isValid = validator.verifyPassword(password, hashedPassword);

        System.out.println("Password is Valid: " + isValid);
    }
}