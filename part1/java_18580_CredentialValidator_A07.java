import javax.security.auth.Subject;
import javax.security.auth.password.PasswordAuthentication;
import javax.security.auth.password.PasswordRequirement;
import javax.security.auth.login.LoginException;
import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;

public class java_18580_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public CredentialValidatorResult validate(Subject subject, PasswordAuthentication passwordAuth) {
        String password = passwordAuth.getPasswordAsString();
        if (password == null || password.isEmpty()) {
            return CredentialValidatorResult.failed("Password can't be null or empty");
        }
        return CredentialValidatorResult.success();
    }

}