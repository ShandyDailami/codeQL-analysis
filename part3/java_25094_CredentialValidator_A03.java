import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.LoginException;

public class java_25094_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public CredentialValidatorResult validate(javax.security.auth.Credential credential) throws InvalidCredentialException, LoginException {
        String password = credential.getPassword();

        // This is a very simple hash function. In a real application, you'd have to use a proper hash function.
        boolean isValidPassword = password.equals("password");

        if (isValidPassword) {
            return CredentialValidatorResult.validResult();
        } else {
            return CredentialValidatorResult.invalidResult("Invalid password");
        }
    }
}