import java.security.Principal;
import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.AbstractLoginModule;

public class java_34189_CredentialValidator_A07 extends AbstractLoginModule {

    @Override
    public CredentialValidationResult validate(Subject subject, Principal principal) {
        String username = principal.toString();
        String password = (String) subject.getCredentials()[0].getCredentialIdentifier();

        if (username.equals("admin") && password.equals("password")) {
            return new CredentialValidationResult("Success", null);
        } else {
            return new CredentialValidationResult("Failure", null);
        }
    }
}