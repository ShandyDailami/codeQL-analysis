import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class java_00092_CredentialValidator_A07 implements LoginModule {

    private String username;
    private String password;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, String username, String password) throws LoginException {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean supports(String authenticationId) {
        return true;
    }

    @Override
    public List<Principal> getPrincipals(Subject subject) {
        List<Principal> principals = new ArrayList<>();
        if (username != null && username.equals("admin")) {
            principals.add(new UserPrincipal("admin"));
        }
        return principals;
    }

    @Override
    public List<String> getAuthorities(Subject subject) {
        List<String> authorities = new ArrayList<>();
        if (username != null && username.equals("admin")) {
            authorities.add("ROLE_ADMIN");
        }
        return authorities;
    }

    @Override
    public String getName() {
        return "CustomLoginModule";
    }

    private static class UserPrincipal implements Principal {
        private String name;

        public java_00092_CredentialValidator_A07(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}