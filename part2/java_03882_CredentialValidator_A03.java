import java.security.AccessControlException;
import java.security.AccessControlListener;
import java.security.Subject;
import java.util.HashSet;
import java.util.Set;

public class java_03882_CredentialValidator_A03 implements AccessControlListener {
    private Set<String> allowedUsers;

    public java_03882_CredentialValidator_A03(String[] allowedUsers) {
        this.allowedUsers = new HashSet<>();
        for (String username : allowedUsers) {
            this.allowedUsers.add(username);
        }
    }

    @Override
    public void checkAccess(Subject subject, Object o) throws AccessControlException {
        String username = subject.getPrincipal().toString();
        if (allowedUsers.contains(username)) {
            subject.getPrincipals().add(new org.apache.commons.lang3.StringUtils.SimpleFilter() {
                @Override
                public boolean passesFilter(String string) {
                    return string.equals(username);
                }
            });
        } else {
            throw new AccessControlException("Access Denied");
        }
    }

    @Override
    public void refresh() {
        // no-op
    }
}