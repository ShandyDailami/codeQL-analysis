import javax.naming.AuthenticationException;
import javax.naming.NamingException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModuleCaller;
import java.security.Principal;
import java.security.acl.UnsupportedActionException;
import java.util.Arrays;
import java.util.List;

public class java_16799_CredentialValidator_A01 implements javax.security.auth.credential.CredentialValidator {

    private static final List<String> AUTHORITIES = Arrays.asList("Admin", "User");

    @Override
    public Subject validate(Subject subject) throws LoginException, UnsupportedActionException {
        Principal principal = new Principal() {
            @Override
            public String getName() {
                return "User";
            }
        };

        for (String authority : AUTHORITIES) {
            if (authority.equals(principal.getName())) {
                principal.setName(authority);
                return new Subject(principal, true);
            }
        }
        throw new AuthenticationException("Invalid credentials");
    }
}