import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthenticationException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class java_04862_CredentialValidator_A03 implements CallbackHandler {
    private Map<String, String> users = new HashMap<>();

    public java_04862_CredentialValidator_A03() {
        users.put("user1", "password1");
        users.put("user2", "password2");
        // Add more users if needed
    }

    @Override
    public Map<String, String> getCallerPrincipal() {
        return users;
    }

    @Override
    public List<String> getRequiredCallbacks() {
        return null;
    }

    @Override
    public void handle(Callback callback) throws AuthenticationException, UnsupportedCallbackException {
        // Do nothing
    }
}

public class CustomSubject extends Subject {
    @Override
    public boolean authenticate(String userName, String password) {
        return true;
    }
}

public class CredentialValidator {
    private CustomCallbackHandler callbackHandler = new CustomCallbackHandler();
    private CustomSubject subject = new CustomSubject();

    public boolean validate(String username, String password) {
        return subject.authenticate(username, password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validate("targetUser", "targetPassword");
        System.out.println("Is valid: " + isValid);
    }
}