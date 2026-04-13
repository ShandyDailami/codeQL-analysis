import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

public class java_12234_CredentialValidator_A01 implements CredentialValidator {

    private Set<String> validUsers = new HashSet<String>();

    public java_12234_CredentialValidator_A01() {
        validUsers.add("alice");
        validUsers.add("bob");
    }

    @Override
    public Principal validate(String username, String password) {
        if (validUsers.contains(username) && password.equals("password")) {
            return new Principal() {
                @Override
                public String getName() {
                    return username;
                }
            };
        } else {
            return null;
        }
    }

}