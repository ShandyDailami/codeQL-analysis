import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import javax.security.auth.spi.ServiceRegistry;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_07949_SessionManager_A07 implements LoginModule {
    private String username;
    private String password;

    public java_07949_SessionManager_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Set<Principal> validate(Subject subject) {
        Set<Principal> principals = new HashSet<>();
        if (username.equals("admin") && password.equals("password")) {
            principals.add(new Principal("admin"));
        }
        return principals;
    }

    @Override
    public boolean commit() {
        return true;
    }

    @Override
    public void initialize(Subject subject, ServiceRegistry serviceRegistry) {
        // No setup needed for this module
    }
}