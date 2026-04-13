import java.security.AuthFailureNotSupportedException;
import java.security.Credential;
import java.security.GeneralSecurityException;

public class java_08763_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public Credential validatedCredential(Credential credential) throws GeneralSecurityException, AuthFailureNotSupportedException {
        // Let's assume we have a list of acceptable usernames and passwords.
        // Here, we'll just check the username and password against our list.
        String[] acceptableUsers = {"user1", "user2", "user3"};
        String[] acceptablePasswords = {"password1", "password2", "password3"};

        String providedUsername = credential.getUsername();
        String providedPassword = new String(credential.getPassword());

        boolean isValid = false;

        for (int i = 0; i < acceptableUsers.length; i++) {
            if (acceptableUsers[i].equals(providedUsername) && acceptablePasswords[i].equals(providedPassword)) {
                isValid = true;
                break;
            }
        }

        if (!isValid) {
            throw new GeneralSecurityException("Invalid username or password");
        }

        // If the username and password are valid, return the original Credential object.
        return credential;
    }
}