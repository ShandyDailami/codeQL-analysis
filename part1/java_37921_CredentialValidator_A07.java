import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

public class java_37921_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator {

    private static final List<String> USERS = Arrays.asList("user1", "user2", "user3");
    private static final List<String> PASSWORDS = Arrays.asList("password1", "password2", "password3");

    @Override
    public boolean validate(Subject subject, String username, String password) {
        return USERS.contains(username) && PASSWORDS.contains(password);
    }

    public static void main(String[] args) throws Exception {
        CredentialValidator validator = new CredentialValidator();

        CallbackHandler callbackHandler = new CallbackHandler() {
            @Override
            public boolean getRequestedPassword(String s, String s1, String s2, String s3) throws IllegalArgumentException {
                return null;
            }

            @Override
            public boolean getPassword(String s, String s1, String s2, String s3) throws IllegalArgumentException {
                return validator.validate(null, s, s1);
            }
        };

        Subject subject = new Subject(new Principal("username"), new HashSet<>(), callbackHandler, null);

        LoginContext loginContext = new LoginContext("realm", subject);
        loginContext.login();

        if (loginContext.getStatus() == 0) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed: " + loginContext.getStatus());
        }
    }
}