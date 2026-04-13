import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.GuardedBy;
import java.security.Principal;
import java.security.PrivilegedAction;

public class java_10967_CredentialValidator_A01 {

    @GuardedBy("this.credentials")
    private final Credential[] credentials;
    private final AccessControlContext accessControlContext;

    public java_10967_CredentialValidator_A01(Credential[] credentials) {
        this.credentials = credentials;
        accessControlContext = AccessControlContext.getDefault();
    }

    public boolean validate(final Principal principal, final String password) {
        return accessControlContext.doPrivileged(new PrivilegedAction<Boolean>() {
            @Override
            public Boolean runPrivileged(PrivilegedAction<Boolean> action) throws AccessDeniedException {
                for (Credential credential : credentials) {
                    if (credential.matches(principal, password)) {
                        return true;
                    }
                }
                return false;
            }
        });
    }

    public static class Credential {
        private final String principal;
        private final String password;

        public java_10967_CredentialValidator_A01(String principal, String password) {
            this.principal = principal;
            this.password = password;
        }

        public boolean matches(Principal principal, String password) {
            return this.principal.equals(principal) && this.password.equals(password);
        }
    }

    public static void main(String[] args) {
        Credential[] credentials = {
                new Credential("admin", "password123"),
                new Credential("user", "password456")
        };
        MinimalistCredentialValidator validator = new MinimalistCredentialValidator(credentials);

        Principal admin = new Principal("admin") {
            @Override
            public boolean equals(Object obj) {
                return obj instanceof Principal && obj.toString().equals(admin.toString());
            }

            @Override
            public String getName() {
                return admin.toString();
            }
        };

        Principal user = new Principal("user") {
            @Override
            public boolean equals(Object obj) {
                return obj instanceof Principal && obj.toString().equals(user.toString());
            }

            @Override
            public String getName() {
                return user.toString();
            }
        };

        System.out.println(validator.validate(admin, "password123")); // prints: true
        System.out.println(validator.validate(user, "password456")); // prints: true
    }
}