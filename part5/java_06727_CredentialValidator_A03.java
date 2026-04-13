import java.util.Base64;
import java.util.HashMap;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth. UsernamePasswordAuthenticationToken;

public class java_06727_CredentialValidator_A03 implements CallbackHandler {

    private HashMap<String, String> credentialStore = new HashMap<>();

    public java_06727_CredentialValidator_A03() {
        // add sample credentials for authentication
        credentialStore.put("admin", Base64.getEncoder().encodeToString("admin:password".getBytes()));
        credentialStore.put("user", Base64.getEncoder().encodeToString("user:password".getBytes()));
    }

    @Override
    public UsernamePasswordAuthenticationToken getAuthenticationToken(CallbackHandler callbackHandler, String authenticationId,
            String callingPrincipal, String callingAccessToken) throws UnsupportedCallbackException {

        Callback[] requiredCallbacks = new Callback[] { new UsernamePasswordAuthenticationToken() };

        return callbackHandler.getAuthenticationToken(requiredCallbacks, authenticationId, callingPrincipal, callingAccessToken);
    }

    public boolean validate(String username, String password) {
        String passwordInBase64 = credentialStore.get(username);

        if (passwordInBase64 != null) {
            byte[] passwordInBytes = Base64.getDecoder().decode(passwordInBase64);
            String passwordFromCredentialsStore = new String(passwordInBytes);

            String[] passwordCredentials = passwordFromCredentialsStore.split(":");

            if (passwordCredentials.length == 2 && passwordCredentials[0].equals(username)
                    && passwordCredentials[1].equals(password)) {
                return true;
            }
        }

        return false;
    }

}