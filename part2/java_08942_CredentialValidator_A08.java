import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_08942_CredentialValidator_A08 {

    public static void main(String[] args) {
        String password = "password";
        String hash = hashPassword(password);
        System.out.println("Hash: " + hash);
        if(isValid(hash, password)) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is invalid");
        }
    }

    private static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isValid(String hash, String password) {
        return hashPassword(password).equals(hash);
    }
}