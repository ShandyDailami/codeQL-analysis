import java.security.Permission;
import java.security.SecurityManager;
import java.security.UnsecureTransportException;
import java.util.HashSet;
import java.util.Set;

public class java_04822_CredentialValidator_A01 implements CredentialValidator {
    private Set<String> authorizedUsers = new HashSet<>();

    public java_04822_CredentialValidator_A01() {
        authorizedUsers.add("user1");
        authorizedUsers.add("user2");
        authorizedUsers.add("user3");
    }

    @Override
    public Set<String> getAuthorizedUsers() {
        return authorizedUsers;
    }

    @Override
    public Permission[] getPermissions() {
        return new Permission[0];
    }

    @Override
    public void validate(String user) throws UnsecureTransportException {
        if (!authorizedUsers.contains(user)) {
            throw new UnsecureTransportException("Unauthorized user detected");
        }
    }
}