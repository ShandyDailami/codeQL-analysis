import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class java_32136_CredentialValidator_A07 implements LoginModule {

    private Subject subject;

    @Override
    public void initialize(Subject subject, String authenticationId, Properties properties) throws LoginException {
        this.subject = subject;
    }

    @Override
    public boolean authenticate(String userName, String password) throws LoginException {
        // Simulate an authentication process. In a real-world scenario, you would use your own authentication logic.
        if (userName.equals("admin") && password.equals("password")) {
            List<String> roles = new ArrayList<>();
            roles.add("ROLE_ADMIN");
            Principal principal = new PrincipalImpl("admin", roles);
            subject.getPrincipalCollection().add(principal);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    @Override
    public void cleanup() throws LoginException {

    }
}