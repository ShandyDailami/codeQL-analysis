import java.util.Arrays;
import java.util.Base64;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth. UsernamePasswordAuthenticationToken;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_23791_CredentialValidator_A07 implements CallbackHandler {
    private String username;
    private char[] password;

    public java_23791_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password.toCharArray();
    }

    @Override
    public UsernamePasswordAuthenticationToken getAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }

    @Override
    public void handle(Callback callback) throws UnsupportedCallbackException {
        callback.done();
    }
}

public class BasicLoginModule implements LoginModule {
    private Subject subject;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> options) throws LoginException {
        this.subject = subject;
        BasicCallbackHandler handler = new BasicCallbackHandler("user", "password");
        subject.getPrincipalCallback().done(handler, handler.getAuthenticationToken());
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    @Override
    public void abort(Subject subject, String action, Exception ex) throws LoginException {
    }

    @Override
    public boolean supports(String action) {
        return action != null && action.equals("commit");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        String username = "user";
        String password = "password";
        String passwordEncoded = Base64.getEncoder().encodeToString((username + password).getBytes());
        String authString = "Basic " + passwordEncoded;
        System.out.println("Authorization: " + authString);
    }
}