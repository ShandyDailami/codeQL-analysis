import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_06151_CredentialValidator_A01 {

    private String username;
    private String password;
    private String hashedPassword;

    public java_06151_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
        try {
            hashedPassword = hashPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public boolean isValid() throws NoSuchAlgorithmException {
        if (username.equals("admin") && hashedPassword.equals(hashPassword("password"))) {
            return true;
        }
        return false;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
}