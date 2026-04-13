import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class java_38975_CredentialValidator_A08 implements LoginModule {

    private String username;
    private char[] password;
    private Set<String> roles = new HashSet<>();

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, String username,
                           char[] password, String[] roles, String options)
            throws IOException, SQLException {
        this.username = username;
        this.password = password;
        this.roles = new HashSet<>(Arrays.asList(roles));
    }

    @Override
    public boolean login() throws IOException, SQLException {
        if (password.length > 8) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean commit() throws IOException, SQLException {
        return login();
    }

    @Override
    public void abort(Subject subject, String action, Exception exception) throws IOException, SQLException {
        // do nothing
    }

    @Override
    public boolean logout() throws IOException, SQLException {
        return true;
    }

    public static void main(String[] args) {
        // This is a test, so we don't do anything with the LoginContext
        try {
            CustomLoginModule module = new CustomLoginModule();
            Subject subject = new Subject.publicInit();
            LoginContext loginContext = new LoginContext("TestRealm", subject, module);
            loginContext.login();
            System.out.println("Logged in: " + loginContext.getSubject().getPrincipal());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}