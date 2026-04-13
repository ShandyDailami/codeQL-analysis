import javax.security.auth.Subject;
import javax.security.auth.login.CredentialException;
import javax.security.auth.spi.LoginModule;

public class java_27160_CredentialValidator_A01 implements LoginModule {

    private String password;

    public java_27160_CredentialValidator_A01(String password) {
        this.password = password;
    }

    @Override
    public boolean validate(Subject subject, String password) throws CredentialException {
        if (this.password != null && this.password.equals(password)) {
            return true;
        }
        return false;
    }
}