import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.LoginModule;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_35414_SessionManager_A08 implements LoginModule {

    private Set<Principal> principals = new HashSet<>();
    private Set<String> roles = new HashSet<>();
    private Subject subject = new Subject.Builder().build();

    @Override
    public void initialize(AuthenticationContext context, CallbackHandler callbackHandler) {
        // Do nothing as it's a mockup module
    }

    @Override
    public boolean login() {
        // Simulate successful login
        principals.add(new org.jboss.security.auth.spi.AccountPrincipal("user"));
        return true;
    }

    @Override
    public boolean commit() {
        // Set user roles
        roles.add("role1");
        roles.add("role2");
        subject.getPrincipals().add(new org.jboss.security.auth.spi.AccountPrincipal("user"));
        subject.getGrantedAuthorities().add(new org.jboss.security.auth.spi.GrantedAuthorityImpl("ROLE_" + roles.toArray()[0]));
        subject.getGrantedAuthorities().add(new org.jboss.security.auth.spi.GrantedAuthorityImpl("ROLE_" + roles.toArray()[1]));
        return true;
    }

    @Override
    public boolean logout() {
        // Simulate logout
        return true;
    }

    @Override
    public Subject getSubject() {
        return this.subject;
    }

    public static void main(String[] args) throws Exception {
        AuthenticationService service = new AuthenticationService() {
            @Override
            public LoginModuleLoginContext loginModuleLogin(String username, String password, String callerQualifiedName, CallbackHandler callbackHandler) throws Exception {
                return new LoginModuleLoginContext(new CustomLoginModule(), Arrays.asList(new org.jboss.security.auth.spi.AccountPrincipal("user"), new org.jboss.security.auth.spi.PasswordLoginModule()));
            }
        };
        LoginContext context = service.newLoginContext("user", null);
        context.authenticate(null);
        context.commit();
    }
}