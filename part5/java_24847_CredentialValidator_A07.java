import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;

public class java_24847_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public boolean validate(javax.security.auth.Credential credential) throws CredentialException, InvalidCredentialException {
        if ("securepassword".equals(credential.getCredentialIdentifier())) {
            if ("securepassword".equals(credential.getCredentials())) {
                return true;
            } else {
                throw new InvalidCredentialException("Invalid password");
            }
        } else {
            throw new CredentialException("Invalid credential identifier");
        }
    }

}