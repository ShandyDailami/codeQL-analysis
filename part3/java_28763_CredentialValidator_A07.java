import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.password.PasswordStore;
import javax.security.auth.password.PasswordValidator;
import javax.security.auth.message.AuthException;

public class java_28763_CredentialValidator_A07 implements PasswordValidator {

    private PasswordStore passwordStore;

    public java_28763_CredentialValidator_A07(PasswordStore passwordStore) {
        this.passwordStore = passwordStore;
    }

    @Override
    public String getName() {
        return "Custom Credential Validator";
    }

    @Override
    public boolean validate(Subject subject, String password) {
        try {
            return passwordStore.validate(subject, password);
        } catch (AuthException | LoginException e) {
            e.printStackTrace();
        }
        return false;
    }
}