import javax.security.auth.callback.*;
import javax.security.auth.login.*;
import javax.security.auth.spi.*;
import java.util.*;

public class java_24738_CredentialValidator_A01 implements CallbackHandler {

    private List<String> allowedUsers = Arrays.asList("user1", "user2", "user3");
    private PasswordCallback pc;
    private boolean allowUnauthenticated;

    public java_24738_CredentialValidator_A01(boolean allowUnauthenticated) {
        this.allowUnauthenticated = allowUnauthenticated;
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public boolean getRequestedAuthTypes(String arg0) throws UnavailableException {
        return true;
    }

    @Override
    public boolean checkClientAuth(String arg0) throws NotAuthorizedException {
        return true;
    }

    @Override
    public boolean commit(String arg0) throws AuthenticationException {
        return true;
    }

    @Override
    public boolean validate(Callback[] arg0) throws IOException, GeneralSecurityException {
        for (Callback callback : arg0) {
            if (callback instanceof PasswordCallback) {
                pc = (PasswordCallback) callback;
                checkPassword();
            }
        }
        return false;
    }

    private void checkPassword() {
        if (allowUnauthenticated && (pc.getPrompt().equals(""))) {
            pc.setRequestedPassword("");
        } else {
            String password = pc.getRequestedPassword();
            if (!allowedUsers.contains(password)) {
                throw new AuthenticationFailedException("Invalid password");
            }
        }
    }
}