import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.UnknownAccountException;
import javax.security.auth.account.Account;
import javax.security.auth.AccountException;
import javax.security.auth.message.MessageException;

public class java_27303_CredentialValidator_A07 {

    public static final String USERNAME = "user";
    public static final String PASSWORD = "password";

    public static void main(String[] args) throws LoginException, AccountException {

        // CallbackHandler which will be used to get the credentials
        CallbackHandler callbackHandler = new CallbackHandler() {
            @Override
            public boolean handle(Callback[] callbacks) throws UnsupportedCallbackException, AccountException, MessageException {
                for (Callback callback : callbacks) {
                    if (callback instanceof UsernameCallback) {
                        ((UsernameCallback) callback).setRequestedPassword("");
                    } else if (callback instanceof PasswordCallback) {
                        ((PasswordCallback) callback).setRequestedPassword(null);
                    }
                }
                return true;
            }
        };

        // Setting up the login context
        LoginContext loginContext = new LoginContext("Realm", new Subject(), callbackHandler, null, null);

        // Performing the login
        loginContext.login();

        // Getting the account
        Account account = loginContext.getAccount();

        // Printing the account information
        System.out.println("Authenticated user: " + account.getIdentifier());
    }

    // Callback used by the login context to provide the username and password
    static class UsernameCallback extends LoginModuleCallback {
        public String getRequestedPassword() {
            return null;
        }
    }

    static class PasswordCallback extends LoginModuleCallback {
        public void setRequestedPassword(String requestedPassword) {
            // Not used
        }
    }
}