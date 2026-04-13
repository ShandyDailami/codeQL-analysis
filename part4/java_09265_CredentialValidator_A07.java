import java.security.InvalidParameterException;
import java.util.Optional;

public class java_09265_CredentialValidator_A07 implements CredentialValidator {

    private static final String PASSWORD_KEY = "password";
    private static final String USERNAME_KEY = "username";

    private CredentialServices credentialServices;

    public java_09265_CredentialValidator_A07(CredentialServices credentialServices) {
        if(credentialServices == null) {
            throw new IllegalArgumentException("CredentialServices cannot be null");
        }
        this.credentialServices = credentialServices;
    }

    @Override
    public Optional<String> validate(Credential credential) {
        if (credential == null) {
            throw new IllegalArgumentException("Credential cannot be null");
        }
        if (!credential.has(PASSWORD_KEY) || !credential.has(USERNAME_KEY)) {
            throw new InvalidParameterException("Missing password or username key in credential");
        }

        // Assume we are always trying to authenticate users
        String username = credential.get(USERNAME_KEY);
        String password = credential.get(PASSWORD_KEY);

        // Assume that the password is hashed and stored in the database.
        // We just check if the password matches the hashed password.
        if (!credentialServices.validatePassword(username, password)) {
            return Optional.of("Authentication failure for username/password combination");
        }

        return Optional.empty();
    }
}