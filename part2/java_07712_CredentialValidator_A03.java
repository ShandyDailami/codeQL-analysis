import java.util.Arrays;
import java.util.List;

import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_07712_CredentialValidator_A03 {

    private static final List<String> VALID_USERS = Arrays.asList("user1", "user2", "user3", "admin");
    private static final List<String> VALID_PASSWORDS = Arrays.asList("password1", "password2", "admin");

    public boolean validate(Credential credential) throws LoginException {
        String username = credential.getIdentifier();
        String password = credential.getCredential();

        if (VALID_USERS.contains(username) && VALID_PASSWORDS.contains(password)) {
            return true;
        } else {
            throw new LoginException("Invalid username or password.");
        }
    }

    public static void main(String[] args) {
        // Create a new instance of the CredentialValidator
        CustomCredentialValidator validator = new CustomCredentialValidator();

        // Create a Credential object
        Credential credential = new UsernamePasswordCredential("user1", "password1");

        // Validate the credential
        try {
            if (validator.validate(credential)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}