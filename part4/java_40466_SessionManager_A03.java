import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_40466_SessionManager_A03 {
    private String secretKey;

    public java_40466_SessionManager_A03(String secretKey) {
        this.secretKey = secretKey;
    }

    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verifyPassword(String password, String hashedPassword) {
        return hashedPassword.equals(hashPassword(password));
    }

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager("ThisIsASecretKey");

        String password = "myPassword";
        String hashedPassword = securityManager.hashPassword(password);
        System.out.println("Hashed Password: " + hashedPassword);

        boolean isVerified = securityManager.verifyPassword(password, hashedPassword);
        System.out.println("Password Verified: " + isVerified);
    }
}