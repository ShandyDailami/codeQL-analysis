import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.util.AbstractDelegateSubject;
import java.security.Guard;

public class java_25101_CredentialValidator_A03 extends AbstractDelegateSubject implements CredentialValidationResult {

    private String password;

    public java_25101_CredentialValidator_A03(String password) {
        this.password = password;
    }

    @Override
    public CredentialValidationResult validate(Subject subject) throws LoginException {
        if (password != null && password.length() > 5 && password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failed();
        }
    }

}