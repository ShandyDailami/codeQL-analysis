import javax.security.auth.login.LoginException;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.login.LoginContext;
import javax.security.auth.Subject;
import java.io.IOException;
import java.security.Principal;
import java.util.Collections;

public class java_38313_CredentialValidator_A07 implements CallbackHandler {

    private Subject subject;

    public java_38313_CredentialValidator_A07(Subject subject) {
        this.subject = subject;
    }

    @Override
    public UsernamePasswordAuthenticationToken getAuthenticationToken(String username, char[] password, boolean rememberMe) throws LoginException {
        Principal principal = new Principal() {
            public String getName() {
                return username;
            }
        };

        return new UsernamePasswordAuthenticationToken(principal, password, Collections.emptyList());
    }

    @Override
    public boolean validate(UsernamePasswordAuthenticationToken token) throws LoginException {
        // No validation needed in this case, we're just returning true
        return true;
    }

    public Subject getSubject() throws LoginException, IOException {
        return LoginContext.runContext("exampleRealm", new javax.security.auth.callback.CallbackHandler() {
            public void handle(javax.security.auth.callback.Callback[] callbacks) throws IOException, LoginException {
                for (int i = 0; i < callbacks.length; ++i) {
                    callbacks[i].done();
                }
            }
        }, subject, getAuthenticationToken("user", "password".toCharArray(), false));
    }
}