import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.*;
import javax.security.auth.spi.*;

public class java_39694_CredentialValidator_A03 implements CallbackHandler, LoginModule {

    private Subject subject;
    private String user;
    private String password;

    public java_39694_CredentialValidator_A03(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public boolean commit() {
        return true;
    }

    public boolean abort(String message) {
        return true;
    }

    public CallbackHandler getCallbackHandler() {
        return this;
    }

    public boolean login() throws LoginException {
        return validate();
    }

    public boolean validate() throws LoginException {
        if (subject == null || subject.getPrincipal() == null) {
            throw new LoginException("Subject or principal is null");
        }

        if (!(subject.getPrincipal() instanceof String)) {
            throw new LoginException("Principal is not a string");
        }

        String principal = (String) subject.getPrincipal();

        if (!principal.equals(user)) {
            throw new LoginException("Username does not match");
        }

        return true;
    }
}