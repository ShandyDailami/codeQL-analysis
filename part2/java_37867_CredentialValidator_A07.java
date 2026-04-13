import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.Principal;
import java.security.auth. Authenticator;
import java.util.HashSet;
import java.util.Set;

public class java_37867_CredentialValidator_A07 implements LoginModule {
    private String username;
    private String password;

    @Override
    public void initialize(Subject subject, String username,
                           String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Set<Principal> getSubject() throws LoginException {
        Set<Principal> principals = new HashSet<>();
        if(isUsernameValid()) {
            principals.add(new UserPrincipal(username));
        } else {
            throw new LoginException("Invalid username");
        }
        return principals;
    }

    private boolean isUsernameValid() {
        // here you can add logic to validate username
        // for example, check if username exists in the database
        // return true if valid, false otherwise
    }

    private static class UserPrincipal implements Principal {
        private String name;

        public java_37867_CredentialValidator_A07(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}