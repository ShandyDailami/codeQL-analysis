import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.CredentialException;
import javax.security.auth.UsernamePasswordToken;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.PasswordCredential;
import javax.security.auth.login.LoginException;

public class java_20227_CredentialValidator_A01 {

    // List of existing users
    private static List<Credential> users = new ArrayList<>();

    static {
        users.add(new PasswordCredential("user1", "password1"));
        users.add(new PasswordCredential("user2", "password2"));
        users.add(new PasswordCredential("user3", "password3"));
    }

    public java_20227_CredentialValidator_A01() {
    }

    public Credential authenticate(String username, String password) throws CredentialException, LoginException {
        for (Credential credential : users) {
            if (credential.getCaller().getName().equals(username)
                    && credential.getCaller().getIdentifier().equals(password)) {
                return credential;
            }
        }
        throw new CredentialException("Invalid credentials");
    }

    public static void main(String[] args) throws LoginException, CredentialException {
        CredentialValidator validator = new CredentialValidator();
        UsernamePasswordToken token = new UsernamePasswordToken("user1", "password1");
        Credential credential = validator.authenticate(token.getCaller(), token.getIdentifier());
        System.out.println(credential.getClass().getName() + " authenticated successfully!");
    }
}