import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordBroker;
import javax.security.auth.login.LoginException;
import java.util.Base64;

public class java_36851_CredentialValidator_A08 implements CredentialValidator {

    private PasswordBroker passwordBroker;
    private String userName;

    public java_36851_CredentialValidator_A08(PasswordBroker passwordBroker, String userName) {
        this.passwordBroker = passwordBroker;
        this.userName = userName;
    }

    @Override
    public String getCallerPrincipal() {
        return userName;
    }

    @Override
    public String getPassword() throws LoginException {
        String password = passwordBroker.getPassword(userName);
        return new String(Base64.getDecoder().decode(password));
    }

    @Override
    public boolean validate(Object credential) throws LoginException {
        String passwordInCredential = ((String) credential).trim();
        String encodedPassword = getPassword();
        return passwordInCredential.equals(encodedPassword);
    }
}