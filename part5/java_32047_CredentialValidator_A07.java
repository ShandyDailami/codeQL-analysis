import java.security.AuthProvider;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

public class java_32047_CredentialValidator_A07 implements AuthProvider {

    private Set<String> allowedUsers = new HashSet<>();

    public java_32047_CredentialValidator_A07() {
        // Add allowed users here for testing
        allowedUsers.add("user1");
        allowedUsers.add("user2");
    }

    @Override
    public Principal authenticate(String username, String password) {
        if (allowedUsers.contains(username) && password.equals("password")) {
            return new Principal() {
                @Override
                public String getName() {
                    return username;
                }
            };
        }
        return null;
    }

    @Override
    public Set<Class<?>> getAcceptedPasswordChangeClasses() {
        return null;
    }

    @Override
    public Set<String> getGrantedAuthorities(Principal principal) {
        return null;
    }

    @Override
    public String getAuthority(Principal principal) {
        return null;
    }

    @Override
    public Set<String> getPreauthenticatedGrantedAuthorities(String s) {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof AuthProvider && obj.getClass().equals(getClass());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}