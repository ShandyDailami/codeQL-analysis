import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import javax.security.auth.spi.ServiceProvider;
import java.security.Principal;
import java.security.auth.UsernamePasswordAuthenticationToken;
import java.security.auth.UnknownAccountException;
import java.util.HashMap;
import java.util.Map;

public class java_34524_CredentialValidator_A03 implements LoginModule {

    private String username;
    private char[] password;

    @Override
    public void initialize(Attributes attributes) throws LoginException {
        username = attributes.getRequiredAttribute(UsernamePasswordAuthenticationToken.USERNAME_ATTRIBUTE);
        password = (char[]) attributes.getRequiredAttribute(UsernamePasswordAuthenticationToken.PASSWORD_ATTRIBUTE);
    }

    @Override
    public boolean validate(Attributes attributes) throws LoginException {
        // Simulate a password validation by checking the username and password
        if (username.equals(new String(password)) && username.equals("admin")) {
            attributes.put(UsernamePasswordAuthenticationToken.USERNAME_ATTRIBUTE, username);
            return true;
        } else {
            throw new UnknownAccountException("Unknown account");
        }
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    @Override
    public void cleanup() {

    }

    @Override
    public Principal getPasswordDatabasePrincipal() throws LoginException {
        return new Principal() {
            @Override
            public String getName() {
                return username;
            }
        };
    }

    @Override
    public boolean supports(String authenticationId) {
        return true;
    }

    @Override
    public boolean supports(Class<?> authenticationId) {
        return true;
    }

    @Override
    public String getName() {
        return "CustomLoginModule";
    }
}