import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.UsernamePasswordCredential;

public class java_11664_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public CredentialValidatorResult validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        String username = credential.getUsername();
        String password = credential.getPassword();

        // Here you would typically connect to a database or another security system
        // to verify the username and password. For simplicity, we'll just check if the
        // username is "admin" and the password is "password".
        if ("admin".equals(username) && "password".equals(password)) {
            return CredentialValidatorResult.validResult();
        } else {
            return CredentialValidatorResult.invalidResult();
        }
    }
}