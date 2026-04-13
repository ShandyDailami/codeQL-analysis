import javax.naming.AuthenticationException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginModule;
import java.util.HashMap;
import java.util.Map;

public class java_15778_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public Credential validate(Credential credential) throws LoginException {
        String user = credential.getIdentifier();
        String password = credential.getPassword();

        if (user != null && password != null) {
            if ("username".equals(user) && "password".equals(password)) {
                return new UsernamePasswordCredential(user, password);
            }
        }

        throw new FailedLoginException(new String[]{"Invalid username or password"});
    }

    @Override
    public boolean validate(CredentialContext context) throws LoginException, FailedLoginException {
        return false;
    }

    @Override
    public boolean validate(Object object) throws LoginException {
        return false;
    }
}