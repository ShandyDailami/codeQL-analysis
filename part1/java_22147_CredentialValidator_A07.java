import javax.security.auth.callback.*;
import javax.security.auth.spi.*;
import java.security.*;
import java.util.*;

public class java_22147_CredentialValidator_A07 implements CallbackHandler, AuthenticationHandler, UsernamePasswordCallbackHandler, SpiCallbackHandler {

    private List<CallbackResult> results;

    public java_22147_CredentialValidator_A07() {
        this.results = new ArrayList<>();
    }

    @Override
    public CallbackResult[] process(Callback[] callbacks) throws IOException, UnavailableException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callbackHandler = (UsernamePasswordCallback) callback;
                String password = callbackHandler.getPassword();
                callbackHandler.setPassword("*****"); // replace password with asterisks
                results.add(new CallbackResult(callbackHandler));
            }
        }
        return results.toArray(new CallbackResult[0]);
    }

    @Override
    public boolean handle(Callback[] callbacks) throws IOException, UnavailableException {
        return process(callbacks) != null;
    }

    @Override
    public boolean getRequestedAuthStatus(Callback[] callbacks) throws IOException, UnavailableException {
        return process(callbacks) != null;
    }

    @Override
    public boolean selected(String target, Callback[] callbacks) throws IOException, UnavailableException {
        return process(callbacks) != null;
    }
}