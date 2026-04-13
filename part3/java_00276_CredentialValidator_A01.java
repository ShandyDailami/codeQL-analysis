import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import java.security.Principal;
import java.util.Collections;

public class java_00276_CredentialValidator_A01 {

    private static final String USER_DN = "user";
    private static final String PASSWORD = "password";
    private static final String USERNAME = "username";

    public static void main(String[] args) throws Exception {
        CredentialValidator validator = new CredentialValidator();
        validator.validateCredentials("username", "password");
    }

    public void validateCredentials(String userName, String password) throws Exception {
        Subject subject = new Subject.publicInit();
        subject.getPrincipals().add(new PrincipalCollection.Builder().add(USER_DN, userName).buildPrincipal());
        subject.getPrivateCredentials().put(USERNAME, password);
        LoginContext loginContext = new LoginContext("", subject, new CallbackHandler() {
            public void handle(Callback[] callbacks) {
            }
        });
        loginContext.login();
        if (!loginContext.verify(Collections.emptyList())) {
            throw new CredentialValidationException("Invalid credentials");
        }
    }

    class CredentialValidationException extends Exception {
        public java_00276_CredentialValidator_A01(String message) {
            super(message);
        }
    }
}