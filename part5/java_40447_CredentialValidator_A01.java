import javax.security.auth.CredentialException;
import javax.security.auth.UsernamePasswordCredentials;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.LoginModule;

public class java_40447_CredentialValidator_A01 implements LoginModule {

    private String expectedUsername;
    private String expectedPassword;
    private UsernamePasswordCredentials expectedCredentials;

    public java_40447_CredentialValidator_A01(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    @Override
    public boolean validate() throws CredentialException {
        UsernamePasswordCredentials providedCredentials = null;

        CallbackHandler callbackHandler = new CallbackHandler() {
            @Override
            public void handle(Callback callback) throws UnsupportedCallbackException, CredentialException {
                providedCredentials = (UsernamePasswordCredentials) callback;
            }
        };

        getNextCallback().process(callbackHandler);

        if (providedCredentials == null) {
            throw new CredentialException("No credentials provided");
        }

        return providedCredentials.getUsername().equals(expectedUsername)
                && providedCredentials.getPassword().equals(expectedPassword);
    }

    @Override
    public boolean getNextCallback() throws UnsupportedCallbackException, CredentialException {
        throw new CredentialException("No more callbacks available");
    }
}