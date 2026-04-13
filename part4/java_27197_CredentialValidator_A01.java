import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class java_27197_CredentialValidator_A01 implements CallbackHandler {
    private final List<String> allowedUsers = Arrays.asList("user1", "user2", "user3");
    private final char[][] allowedPasswords = { "password1".toCharArray(), "password2".toCharArray(), "password3".toCharArray() };

    public java_27197_CredentialValidator_A01() {}

    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        // Nothing to do here
    }

    public Subject doValidation(CallbackHandler callbackHandler, Subject subject) throws IOException, UnsupportedCallbackException {
        return subject;
    }
}

public class MyCredentialValidator implements javax.security.auth.credential.CredentialValidator {
    public java_27197_CredentialValidator_A01() {}

    public Subject validate(Subject subject) throws IllegalArgumentException, IllegalStateException {
        String username = subject.getPrincipals().get(0).getName();
        char[] password = (char[]) subject.getCredentials();

        if (!isValid(username, password)) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        return subject;
    }

    private boolean isValid(String username, char[] password) {
        return Arrays.asList(allowedUsers.toArray(new String[0])).contains(username) && Arrays.equals(allowedPasswords[allowedUsers.indexOf(username)], password);
    }
}

public class Main {
    public static void main(String[] args) {
        // Initialize your security manager with your credential validator
        Security.addCallbackHandler(new MyCallbackHandler());
        Security.setCredentialValidator(new MyCredentialValidator());
    }
}