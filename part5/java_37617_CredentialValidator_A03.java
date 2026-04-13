import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;

import java.security.Principal;
import java.util.Set;

public class java_37617_CredentialValidator_A03 implements CredentialValidator {

    private Map<String, String> users;

    public java_37617_CredentialValidator_A03() {
        users = new HashMap<>();
        users.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        users.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public boolean validate(Subject subject, Credential credential) throws LoginException {
        String userName = credential.getID();
        String password = new String(credential.getCredentialIdentifier());

        if (users.containsKey(userName) && users.get(userName).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean getSupported(CallbackHandler callbackHandler) {
        return true;
    }

    @Override
    public boolean getRequirement(CallbackHandler callbackHandler) {
        return true;
    }

    @Override
    public Set<Principal> getPrincipals(CallbackHandler callbackHandler) throws LoginException {
        return null;
    }

    @Override
    public Set<String> getAllSupported(CallbackHandler callbackHandler) throws LoginException {
        return null;
    }

    @Override
    public void cleanup(CallbackHandler callbackHandler) throws LoginException {

    }

    @Override
    public boolean supports(String authenticationMethod) {
        return authenticationMethod.equals("CUSTOM");
    }

    @Override
    public boolean commit(CallbackHandler callbackHandler) throws LoginException, UnsupportedCallbackException {
        return true;
    }

    @Override
    public boolean abort(CallbackHandler callbackHandler) throws LoginException {
        return true;
    }

    @Override
    public boolean validate(CallbackHandler callbackHandler, Credential credential) throws LoginException {
        return true;
    }

    @Override
    public boolean getAllSupported(Callback callback) throws LoginException {
        return true;
    }

    @Override
    public boolean supports(String authenticationMethod, Callback callback) throws LoginException {
        return true;
    }

    @Override
    public boolean commit(Callback callback) throws LoginException, UnsupportedCallbackException {
        return true;
    }

    @Override
    public boolean abort(Callback callback) throws LoginException {
        return true;
    }

}