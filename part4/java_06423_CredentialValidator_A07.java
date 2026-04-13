import java.security.InvalidParameterException;
import java.util.Base64;
import javax.security.auth.login.CredentialException;

public class java_06423_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public boolean validate(String credentialId, byte[] credentials) throws CredentialException {
        if (credentials == null) {
            throw new InvalidParameterException("Null credentials");
        }

        String decodedCredentials = new String(credentials);
        String[] decodedCredentialPairs = decodedCredentials.split(":");

        if (decodedCredentialPairs.length != 2) {
            throw new CredentialException("Invalid credentials format");
        }

        String username = decodedCredentialPairs[0];
        String password = decodedCredentialPairs[1];

        // This is a very simple example where we just check if the password is valid.
        // In a real scenario, you should use a more complex algorithm for checking passwords.
        if ("admin".equals(username) && "password".equals(password)) {
            return true;
        } else {
            throw new CredentialException("Invalid credentials");
        }
    }
}