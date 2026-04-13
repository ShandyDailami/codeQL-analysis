import javax.naming.AuthenticationException;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

public class java_38594_CredentialValidator_A07 {

    private String[][] credentials = {
        {"user", "password"},
        {"admin", "admin"},
        {"user2", "password2"}
    };

    public boolean validate(String username, String password) {
        for (int i = 0; i < credentials.length; i++) {
            if (credentials[i][0].equals(username) && credentials[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        try {
            validator.validate("user", "password"); // this should return true
            validator.validate("non-existent-user", "wrong-password"); // this should return false
        } catch (FailedLoginException | CredentialNotFoundException | LoginException | AuthenticationException e) {
            e.printStackTrace();
        }
    }
}