import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.user.CredentialNotFoundException;
import javax.security.auth.user.UserPrincipal;
import javax.security.auth.user.UserStateException;
import javax.security.auth.user.callback.UnsupportedCallbackException;
import javax.security.auth.message.MessageException;

public class java_17849_CredentialValidator_A08 implements CredentialValidator {

    private static final List<String> validUsers = new ArrayList<>();

    static {
        validUsers.add("user");
        validUsers.add("admin");
    }

    @Override
    public CredentialValidationResult validate(Subject subject, CallbackHandler callbackHandler,
            Callback[] callbacks) throws LoginException, CredentialNotFoundException, UserStateException, UnsupportedCallbackException, MessageException {
        CredentialValidationResult result;

        final UserPrincipal principal;

        final List<Callback> listCallbacks = new ArrayList<>();
        listCallbacks.add(new Callback() {
            @Override
            public void handle(Callback[] callbacks) {
                // do nothing
            }

            @Override
            public void setParameter(String parameter) {
                // do nothing
            }
        });

        if (callbackHandler != null) {
            callbackHandler.handle(listCallbacks);
        }

        String username = (String) listCallbacks.get(0).getResult();

        if (validUsers.contains(username)) {
            principal = new UserPrincipal(username);
            result = new CredentialValidationResult(principal, "Unknown", "Unknown", "Unknown", "Unknown");
        } else {
            result = new CredentialValidationResult("Unknown", "Unknown", "Unknown", "Unknown", "Unknown");
        }

        return result;
    }

}