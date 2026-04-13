import java.util.Base64;

public class java_16831_CredentialValidator_A01 {

    private String encodedUser;

    public java_16831_CredentialValidator_A01(String user, String password) {
        String userPassword = user + ":" + password;
        this.encodedUser = Base64.getEncoder().encodeToString(userPassword.getBytes());
    }

    public boolean isValid(String user, String password) {
        if (user == null || password == null) {
            return false;
        }
        
        String userPassword = user + ":" + password;
        String encodedAttempt = Base64.getEncoder().encodeToString(userPassword.getBytes());
        
        return encodedAttempt.equals(this.encodedUser);
    }
}