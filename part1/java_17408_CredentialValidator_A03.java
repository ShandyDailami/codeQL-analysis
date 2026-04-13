import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.login.LoginException;

public class java_17408_CredentialValidator_A03 implements CallbackHandler {

    private String user;
    private String password;

    public java_17408_CredentialValidator_A03(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException, LoginException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordAuthenticationToken) {
                UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) callback;
                String inputUser = authenticationToken.getUserName();
                String inputPassword = authenticationToken.getPassword().toString();

                if (inputUser != null && inputUser.equals(this.user) &&
                        inputPassword != null && inputPassword.equals(this.password)) {
                    authenticationToken.setPassword(null);
                    authenticationToken = new UsernamePasswordAuthenticationToken(user, password, null);
                } else {
                    throw new LoginException("Invalid username or password");
                }
            } else {
                throw new UnsupportedCallbackException(callback, "Unsupported callback");
            }
        }
    }
}

public class CustomCredentialValidator {

    private CustomCallbackHandler callbackHandler;

    public java_17408_CredentialValidator_A03(String user, String password) {
        this.callbackHandler = new CustomCallbackHandler(user, password);
    }

    public boolean authenticate() throws LoginException {
        return true;
    }
}