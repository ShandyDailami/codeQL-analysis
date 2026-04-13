import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;
import java.util.Base64;

public class java_37998_CredentialValidator_A01 implements CredentialValidator {

    private static final String SPECIFIC_PASSWORD = "c3po";

    @Override
    public boolean validate(javax.security.auth.Credential credential) throws CredentialException, InvalidCredentialException {
        String decodedPass = new String(Base64.getDecoder().decode(credential.getCredentialIdentifier()));
        return decodedPass.equals(SPECIFIC_PASSWORD);
    }
}