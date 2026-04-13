import javax.management.AuthenticationFailedException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_09045_SessionManager_A01 {

    private String username;
    private String password;
    private String encryptedPassword;

    public java_09045_SessionManager_A01(String username, String password) throws NoSuchAlgorithmException {
        this.username = username;
        this.password = password;
        this.encryptedPassword = encryptPassword(password);
    }

    private String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(password.getBytes());
        return new String(digest);
    }

    public boolean authenticate() throws AuthenticationFailedException {
        if (encryptPassword(password).equals(this.encryptedPassword)) {
            return true;
        } else {
            throw new AuthenticationFailedException("Authentication Failed");
        }
    }
}