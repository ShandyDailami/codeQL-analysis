import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.LoginModule;
import java.security.Principal;
import java.util.Map;

public class java_08950_CredentialValidator_A07 implements LoginModule {

    private String user = "user";
    private String password = "password";

    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> options) throws LoginException {
        // No-op
    }

    public boolean commit() throws LoginException {
        return true;
    }

    public boolean abort() throws LoginException {
        return true;
    }

    public boolean logout() throws LoginException {
        return true;
    }

    public Subject getSubject(CallbackHandler callbackHandler, Map<String, ?> options) throws LoginException, UnsupportedCallbackException {
        return new Subject() {
            public boolean authenticate(String authenticationId) throws LoginException {
                return false;
            }

            public boolean getAllPrincipals(Principal[] principals) throws LoginException {
                principals[0] = new Principal("User");
                return true;
            }

            public boolean getAllAuthorities(Authority[] authorities) throws LoginException {
                // No authorities required for our module
                return true;
            }

            public boolean implies(Subject subject, String authority) throws LoginException {
                return false;
            }
        };
    }

    public AuthenticationService getAuthenticationService() {
        return new AuthenticationService() {
            public boolean quickLogin(String username, String password, Map<String, ?> options) throws LoginException {
                if (this.user.equals(username) && this.password.equals(password)) {
                    return true;
                } else {
                    return false;
                }
            }

            public boolean commit() throws LoginException {
                return true;
            }

            public boolean abort() throws LoginException {
                return true;
            }

            public boolean logout() throws LoginException {
                return true;
            }

            public Subject getSubject(CallbackHandler callbackHandler, Map<String, ?> options) throws LoginException, UnsupportedCallbackException {
                return new Subject() {
                    public boolean authenticate(String authenticationId) throws LoginException {
                        return false;
                    }

                    public boolean getAllPrincipals(Principal[] principals) throws LoginException {
                        principals[0] = new Principal("User");
                        return true;
                    }

                    public boolean getAllAuthorities(Authority[] authorities) throws LoginException {
                        // No authorities required for our module
                        return true;
                    }

                    public boolean implies(Subject subject, String authority) throws LoginException {
                        return false;
                    }
                };
            }
        };
    }
}