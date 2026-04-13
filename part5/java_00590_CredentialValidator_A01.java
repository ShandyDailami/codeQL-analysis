import javax.security.auth.Credential;
import javax.security.auth.InvalidCredentialDataException;
import javax.security.auth.login.CredentialException;

public class java_00590_CredentialValidator_A01 {
    public static void validate(Credential credential) throws CredentialException, InvalidCredentialDataException {
        String username = credential.getIdentifier();
        char[] password = credential.getPassword();

        // Validate the username. This is a simplistic example, you may want to use a more complex method
        if (username == null || username.length() == 0) {
            throw new InvalidCredentialDataException("Username is required");
        }

        // Validate the password. This is also a simplistic example, you may want to use a more complex method
        if (password == null || password.length == 0) {
            throw new InvalidCredentialDataException("Password is required");
        }

        // If everything is valid, we can log in
        System.out.println("Logging in with username: " + username);
    }
}