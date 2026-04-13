import java.util.Base64;

import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_34320_CredentialValidator_A07 implements CredentialValidator {

    private String password;

    public java_34320_CredentialValidator_A07(String password) {
        this.password = password;
    }

    @Override
    public String getCallerPrincipal() {
        return "credential validator";
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Subject getSubject() {
        return null;
    }

    @Override
    public boolean validate(Subject subject, Object credentials) throws LoginException {
        String suppliedPassword = new String(Base64.getDecoder().decode((String) credentials));
        return this.password.equals(suppliedPassword);
    }
}