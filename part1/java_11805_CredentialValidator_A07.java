import java.util.Base64;
import java.util.regex.Pattern;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.role.Role;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_11805_CredentialValidator_A07 implements LoginModule {
    private String username = null;
    private String password = null;
    private Subject subject = null;

    public java_11805_CredentialValidator_A07() {
    }

    public void initialize(Subject subject, CallbackHandler callbackHandler, Role[] roles) throws LoginException {
        this.subject = subject;
        Callback[] callbacks = new Callback[1];
        callbackHandler.handle(new Callback[]{callbacks[0] = new UsernamePasswordCallback()});
        this.username = callbacks[0].getUsername();
        this.password = callbacks[0].getPassword();
        if (this.username == null || this.password == null)
            throw new LoginException("Username or password not provided");
    }

    public String getPassword(String userName) {
        return this.password;
    }

    public Role[] getRoles(String userName) throws LoginException {
        if(userName == null || userName.length() == 0)
            throw new LoginException("Username not provided");
        return new Role[]{new Role("USER")};
    }

    public String getCallerPrincipal() {
        return this.username;
    }

    public int accessControl(String className, Object attributes) throws LoginException {
        if (className == null || className.length() == 0)
            throw new LoginException("Class name not provided");
        if (attributes == null)
            throw new LoginException("Attributes not provided");
        return 0;
    }

    public class UsernamePasswordCallback implements Callback {
        private String username;
        private String password;

        public java_11805_CredentialValidator_A07() {
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return this.username;
        }

        public String getPassword() {
            return this.password;
        }

        public boolean execute(String action) throws LoginException {
            if (action == null || action.length() == 0)
                throw new LoginException("Action not provided");
            return false;
        }
    }
}