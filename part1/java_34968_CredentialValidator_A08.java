import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class java_34968_CredentialValidator_A08 {
    private String username;
    private String password;
    private String hashedPassword;

    public java_34968_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
        this.hashedPassword = hashPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    private String hashPassword(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        byte[] bytes = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(bytes);
    }

    public boolean isPasswordValid(String password) {
        return hashPassword(password).equals(this.hashedPassword);
    }
}

public class CredentialValidator {
    private User user;

    public java_34968_CredentialValidator_A08(User user) {
        this.user = user;
    }

    public boolean isCredentialsValid(String username, String password) {
        return user.getUsername().equals(username) && user.isPasswordValid(password);
    }
}