import java.security.InvalidParameterException;
import java.util.Base64;

public class java_17710_CredentialValidator_A07 implements CredentialValidator {
    private String validUsername;
    private String validPassword;

    public java_17710_CredentialValidator_A07(String username, String password) {
        this.validUsername = username;
        this.validPassword = password;
    }

    @Override
    public boolean validate(Credential cred) throws InvalidParameterException {
        if (cred == null) {
            throw new InvalidParameterException("Null credentials provided");
        }

        if (cred.getIdentifier() == null || cred.getCredential() == null) {
            throw new InvalidParameterException("Missing username or password in credentials");
        }

        String providedUsername = new String(Base64.getDecoder().decode(cred.getIdentifier()));
        String providedPassword = new String(Base64.getDecoder().decode(cred.getCredential()));

        if (providedUsername.equals(this.validUsername) && providedPassword.equals(this.validPassword)) {
            return true;
        } else {
            return false;
        }
    }
}