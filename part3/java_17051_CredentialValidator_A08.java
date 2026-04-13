import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_17051_CredentialValidator_A08 {
    private static final String SALT = "Salt";

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(SALT.getBytes());
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public static boolean validatePassword(String password, String hashedPassword) throws NoSuchAlgorithmException {
        return hashedPassword.equals(hashPassword(password));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "password";
        String hashedPassword = hashPassword(password);
        System.out.println("Hashed Password: " + hashedPassword);
        System.out.println("Validate: " + validatePassword(password, hashedPassword));
    }
}