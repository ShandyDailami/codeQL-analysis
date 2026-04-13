import java.security.InvalidParameterException;
import java.util.Base64;

import javax.security.auth.login.CredentialException;
import javax.security.auth.Credential;
import javax.security.auth.PasswordAuthentication;
import javax.security.auth.login.LoginException;

public class java_21679_CredentialValidator_A07 implements javax.security.auth.CredentialValidator {

    // This is a simple username and password validator.
    // It only accepts valid credentials and throws an exception otherwise.

    @Override
    public Credential validate(Credential credential) throws CredentialException, LoginException {
        String username = credential.getIdentifier();
        String password = credential.getPassword();

        // In a real scenario, you should use a secure way to hash and verify passwords.
        // This is just a simple example.
        String expectedPassword = "expected_password";

        // Decode the password for comparison
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedExpectedPassword = new String(decodedPassword);

        if (decodedExpectedPassword.equals(expectedPassword)) {
            return new PasswordAuthentication(username, decodedPassword, "Expected Realm");
        } else {
            throw new CredentialException("Invalid Credentials");
        }
    }

}