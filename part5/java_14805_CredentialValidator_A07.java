import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import javax.security.auth.spi.ServiceRegistry;
import javax.security.auth.spi.ServiceRegistries;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_14805_CredentialValidator_A07 implements LoginModule {

    private Subject subject;
    private ServiceRegistry serviceRegistry;
    private Set<String> usernameSet;
    private String[] roles;

    @Override
    public void initialize(Subject subject, ServiceRegistry serviceRegistry, String[] roles) {
        this.subject = subject;
        this.serviceRegistry = serviceRegistry;
        this.roles = roles;
        this.usernameSet = new HashSet<>(Arrays.asList(roles));
    }

    @Override
    public boolean validate(String username, String password) {
        if (usernameSet.contains(username)) {
            if (username.equals("admin")) {
                return true;
            } else {
                throw new AccessControlException("Access Denied");
            }
        } else {
            throw new AccessControlException("User not found");
        }
    }

    @Override
    public boolean commit() {
        return true;
    }

    @Override
    public boolean abort() {
        return false;
    }

    @Override
    public Set<String> getAcceptedPasswordTypes() {
        return new HashSet<>(Arrays.asList("plaintext"));
    }

    @Override
    public Set<String> getAcceptedUsernameTypes() {
        return new HashSet<>(Arrays.asList("plaintext"));
    }

    public static void main(String[] args) {
        try {
            LoginModule module = new CustomLoginModule();
            ServiceRegistries.initialize(null);
            Subject subject = new Subject.Public();
            ServiceRegistry serviceRegistry = ServiceRegistries.getServiceRegistry(Subject.class);
            serviceRegistry.registerLoginModule(module, null, null, null);
            subject.runAs(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}