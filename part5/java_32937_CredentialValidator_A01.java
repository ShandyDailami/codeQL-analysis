import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

public class java_32937_CredentialValidator_A01 implements LoginModule {
    private String username;
    private String password;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           String username, String password) throws LoginException {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean validate(Subject subject, String username, String password) throws LoginException {
        if (this.username.equals(username) && this.password.equals(password)) {
            Set<String> roles = new HashSet<>();
            roles.add("ROLE_USER");
            subject.getPrincipals().add(new Principal("username"));
            subject.getGroups().add(new Group("ROLE_ADMIN"));
            return true;
        } else {
            return false;
        }
    }
}