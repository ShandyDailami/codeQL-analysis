import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.AuthenticationService.Info;

public class java_20809_CredentialValidator_A07 implements AuthenticationService {

    private String user = "admin";
    private String password = "password";

    public Info<CallbackHandler> getInfo() throws LoginException {
        return null;
    }

    public void setInfo(Info<?> info) throws LoginException {
    }

    public String getPassword(String s) throws LoginException {
        return password;
    }

    public List<String> getCallerPrincipals(Subject subject) throws LoginException {
        List<String> list = new ArrayList<>();
        list.add(user);
        return list;
    }

    public List<String> getGrantedAuthorities(Subject subject) throws LoginException {
        return null;
    }

    public void validate(Subject subject, CallbackHandler callbackHandler)
            throws LoginException, UnsupportedCallbackException {
        // No additional validation required in this case
    }
}

public class CustomCallbackHandler implements CallbackHandler {

    private CustomAuthenticationService authService = new CustomAuthenticationService();

    public Callback[] getCallbacks() {
        return new Callback[]{new UsernamePasswordCallback("admin", "password")};
    }

    public void cleanup(Callback[] callbacks) {
        // No cleanup required in this case
    }

    public <A> A getAuthenticationState(Class<A> aClass, Object o) throws LoginException {
        return null;
    }
}

public class Main {

    public static void main(String[] args) {
        javax.security.auth.login.LoginContext loginContext = new javax.security.auth.login.LoginContext("CustomRealm", new CustomCallbackHandler());
        loginContext.login();
        System.out.println("Logged in: " + loginContext.getAuthenticatedPrincipal());
    }
}