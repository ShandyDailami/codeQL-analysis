import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_21838_SessionManager_A03 implements LoginModule {

    private String username;
    private char[] password;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           String authName, String userName, String password)
            throws LoginException, IOException, IllegalSystemException {
        this.username = userName;
        this.password = password.toCharArray();
    }

    @Override
    public boolean commit() throws LoginException, IllegalStateException {
        // If the username is correct and password is correct, return true
        // If not, return false
        return this.username.equals("admin") && Arrays.equals(this.password, "password".toCharArray());
    }

    @Override
    public boolean abort() throws IllegalStateException {
        // If an error occurs, return false
        return false;
    }

    @Override
    public Set<String> getAcceptedPasswordTypes() {
        return new HashSet<>(Arrays.asList("password", "password123"));
    }

    @Override
    public boolean supportsStoringPassword() {
        // Return true if passwords can be stored, false otherwise
        return false;
    }
}