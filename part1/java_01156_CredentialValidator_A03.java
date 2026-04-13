import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_01156_CredentialValidator_A03 {
    private MessageDigest md;
    private SecureRandom sr;

    public java_01156_CredentialValidator_A03() {
        try {
            md = MessageDigest.getInstance("SHA-256");
            sr = new SecureRandom();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String hashPassword(String password) {
        byte[] hashedPassword = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hashedPassword.length; i++) {
            sb.append(Integer.toString((hashedPassword[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public boolean verifyPassword(String password, String hashedPassword) {
        return hashPassword(password).equals(hashedPassword);
    }

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();
        String password = "password";
        String hashedPassword = validator.hashPassword(password);
        System.out.println("Hashed Password: " + hashedPassword);
        System.out.println("Verification Result: " + validator.verifyPassword(password, hashedPassword));
    }
}