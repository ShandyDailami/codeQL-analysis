import javax.security.auth.Subject;
import javax.security.auth.password.PasswordAuthentication;
import javax.security.auth.password.PasswordValidator;
import javax.security.auth.login.LoginException;
import java.security.AuthenticationException;

public class java_29219_CredentialValidator_A07 implements PasswordValidator {
    private String requiredPassword;

    public java_29219_CredentialValidator_A07(String requiredPassword) {
        this.requiredPassword = requiredPassword;
    }

    @Override
    public String getPasswordName() {
        return "Custom Password";
    }

    @Override
    public PasswordAuthentication validate(Subject subject, String password) throws AuthenticationException {
        if (password == null) {
            throw new IllegalArgumentException("password cannot be null");
        }

        if (password.equals(this.requiredPassword)) {
            return new PasswordAuthentication(password, null);
        } else {
            return null;
        }
    }
}