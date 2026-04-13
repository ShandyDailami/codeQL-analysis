import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.*;
import javax.security.auth.spi.*;
import java.security.*;
import java.util.*;

public class java_35268_CredentialValidator_A08 implements CallbackHandler {

    private AuthenticationToken callback;

    public java_35268_CredentialValidator_A08(AuthenticationToken callback) {
        this.callback = callback;
    }

    public AuthenticationToken getCallback() {
        return callback;
    }

    @Override
    public AuthenticationToken getRequestToken(String s) throws UnavailableException {
        throw new UnavailableException("Not supported");
    }

    @Override
    public AuthenticationToken challengePassword(String s, String s1, String s2) throws LoginException {
        throw new LoginException("Not supported");
    }

    @Override
    public void setCallbackHandler(CallbackHandler callbackHandler) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public boolean checkRole(Subject subject, String role) throws IllegalArgumentException {
        throw new IllegalArgumentException("Not supported");
    }

    @Override
    public boolean commit() throws InvalidCredentialDataException {
        throw new InvalidCredentialDataException("Not supported");
    }

    public static void main(String[] args) throws Exception {
        AuthenticationToken callback = new AuthenticationToken("user", "password".toCharArray());
        new CredentialValidator(callback).authenticate(callback);
    }
}