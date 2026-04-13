import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthenticationException;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.CallbackHandler;

public class java_24295_CredentialValidator_A07 implements CallbackHandler {
    private static final String USER_VALID = "validUser";
    private static final String PASS_VALID = "validPass";

    private Map<String, String> users = new HashMap<>();

    public java_24295_CredentialValidator_A07() {
        users.put(USER_VALID, PASS_VALID);
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException,
            UnsupportedCallbackException, AuthenticationException {
        for (Callback callback : callbacks) {
            callback.setCallbackType("UsernamePasswordCallback");
        }
        // Return an authenticated subject (i.e., user)
        Subject subject = new Subject() {
            @Override
            public boolean authenticate(String arg0, String arg1)
                    throws AuthenticationException {
                if (arg0.equals(USER_VALID) && arg1.equals(PASS_VALID)) {
                    return true;
                } else {
                    throw new AuthenticationException("Invalid username or password");
                }
            }
        };
        callbacks[0].setCallbackType("UsernamePasswordCallback");
        callbacks[0].setString(0, USER_VALID);
        callbacks[1].setString(0, PASS_VALID);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        CallbackHandler handler = validator.getCallbackHandler();
        try {
            handler.get(new Callback[]{new UsernamePasswordCallback("", "")});
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedCallbackException e) {
            e.printStackTrace();
        } catch (AuthenticationException e) {
            System.out.println("Authenticated!");
        }
    }
}