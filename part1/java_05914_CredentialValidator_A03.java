import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.x500.X500Principal;

public class java_05914_CredentialValidator_A03 {

    private static class SimpleCredentialValidationResult implements CredentialValidationResult {
        private boolean success;
        private Set<X500Principal> principals;
        private Set<String> groups;

        public java_05914_CredentialValidator_A03(boolean success, Set<X500Principal> principals, Set<String> groups) {
            this.success = success;
            this.principals = principals;
            this.groups = groups;
        }

        public boolean isSuccess() {
            return success;
        }

        public Set<X500Principal> getPrincipals() {
            return principals;
        }

        public Set<String> getGroups() {
            return groups;
        }

        @Override
        public boolean getSuccess() {
            return isSuccess();
        }

        @Override
        public Set<? extends X500Principal> getPrincipals(Class<? extends X500Principal> targetClass) {
            return getPrincipals();
        }

        @Override
        public Set<? extends String> getGroups(Class<? extends String> targetClass) {
            return getGroups();
        }
    }

    private static class MemoryCredentialStore implements javax.security.auth.credential.CredentialStore {
        private final Set<CredentialValidationResult> store = new HashSet<>();

        public void add(CredentialValidationResult result) {
            store.add(result);
        }

        @Override
        public CredentialValidationResult validate(Subject subject, Object credentials) {
            for (CredentialValidationResult result : store) {
                if (result.getPrincipals().contains(subject.getPrincipal())) {
                    return result;
                }
            }
            return new SimpleCredentialValidationResult(false, null, null);
        }
    }

    public static void main(String[] args) {
        MemoryCredentialStore store = new MemoryCredentialStore();
        store.add(new SimpleCredentialValidationResult(true, Arrays.asList(new X500Principal("CN=User1, OU=Users, O=Test, C=US")), Arrays.asList("user")));
        store.add(new SimpleCredentialValidationResult(false, Arrays.asList(new X500Principal("CN=User2, OU=Users, O=Test, C=US")), Arrays.asList("admin")));

        Subject subject = new Subject.publicKeyInitializeSelf(Security.getDefault());
        Authenticator authenticator = new Authenticator() {
            @Override
            public CredentialValidationResult validate(Subject subject, Object credentials) {
                return store.validate(subject, credentials);
            }
        };

        LoginContext loginContext = new LoginContext("Test", subject, authenticator);
        loginContext.login();

        System.out.println("User: " + subject.getPrincipal().getName());
        System.out.println("Groups: " + subject.getGroups());
    }
}