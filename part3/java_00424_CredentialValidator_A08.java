import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.CredentialStatus;

public class java_00424_CredentialValidator_A08 implements CredentialValidator {

    private static final String[][] userCredentials = {
        {"alice", "password1"},
        {"bob", "password2"},
        {"charlie", "password3"}
    };

    @Override
    public CredentialStatus validate(javax.security.auth.Credential credential) throws InvalidCredentialException {
        String username = credential.getIdentifier();
        String password = credential.getPassword();

        for (String[] user : userCredentials) {
            if (user[0].equals(username) && user[1].equals(password)) {
                return CredentialStatus.VALID;
            }
        }

        return CredentialStatus.INVALID;
    }
}