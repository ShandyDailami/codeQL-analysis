import java.security.InvalidParameterException;
import java.security.InvalidCredentialsException;
import java.security.AuthenticationException;
import java.util.Base64;

import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialValidationResult;
import javax.security.auth.credential.PasswordCredential;
import javax.security.auth.message.AuthException;

public class java_01863_CredentialValidator_A01 implements javax.security.auth.credential.CredentialValidator {

    @Override
    public CredentialValidationResult validate(Credential credential) throws InvalidParameterException, AuthenticationException {
        String username = credential.getID();
        String password = new String(credential.getCredentialIdentifier());

        // Simulate a simple user database.
        // In a real-world application, you would likely retrieve the user's password from a database.
        String[] users = {"user1", "user2", "user3"};
        boolean isValid = false;

        for (String user : users) {
            if (user.equals(username)) {
                isValid = true;
                break;
            }
        }

        if (!isValid) {
            return CredentialValidationResult.failure("Invalid username");
        }

        String correctPassword = "password"; // The correct password for the user

        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String providedPassword = new String(decodedPassword);

        if (!providedPassword.equals(correctPassword)) {
            return CredentialValidationResult.failure("Invalid password");
        }

        return CredentialValidationResult.success();
    }

}