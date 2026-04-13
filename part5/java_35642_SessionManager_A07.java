import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.Principal;
import java.util.Collections;
import java.util.Set;

public class java_35642_SessionManager_A07 implements LoginModule {

    private Subject subject;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, String arg2) throws LoginException {
        this.subject = subject;
    }

    @Override
    public boolean login() throws LoginException {
        Principal principal = subject.getPrincipal();
        if (principal == null || !principal.getName().equals("admin")) {
            throw new LoginException("Invalid credentials");
        }
        return true;
    }

    @Override
    public boolean logout() {
        return true;
    }

    @Override
    public Set<Principal> getLoggedProviders() {
        return Collections.singletonList(subject.getPrincipal());
    }

    @Override
    public boolean isLoggedIn() {
        Principal principal = subject.getPrincipal();
        return principal != null && principal.getName().equals("admin");
    }

    @Override
    public String getName() {
        return "CustomSessionManager";
    }
}