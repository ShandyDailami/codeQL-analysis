import java.security.credential.Credential;
import java.security.credential.CredentialSubject;
import java.security.spec.InvalidParameterSpecException;

public class java_26848_CredentialValidator_A08 implements javax.security.auth.login.CredentialValidator {

    @Override
    public Credential validate(Credential credential) throws InvalidParameterSpecException {

        String password = credential.getCredentialIdentifier();

        if ("test".equals(password)) {
            return credential;
        } else {
            throw new InvalidParameterSpecException("Invalid password");
        }
    }

    @Override
    public boolean requiresUsername() {
        return false;
    }

    @Override
    public boolean requiresPassword() {
        return false;
    }

    @Override
    public boolean requiresGroupMembership() {
        return false;
    }

    @Override
    public CredentialSubject getSubject(Credential credential) throws InvalidParameterSpecException {
        return null;
    }

    @Override
    public boolean isHow(String how) throws InvalidParameterSpecException {
        if ("validatePassword".equals(how)) {
            return true;
        } else {
            throw new InvalidParameterSpecException("Invalid how parameter");
        }
    }
}