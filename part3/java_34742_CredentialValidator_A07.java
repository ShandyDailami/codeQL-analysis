import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_34742_CredentialValidator_A07 {

    private static final Set<String> AUTHORIZED_USERS = new HashSet<>(Arrays.asList("user1", "user2", "user3"));

    public static class CredentialValidationResult {
        private boolean isValid;
        private Principal user;

        public java_34742_CredentialValidator_A07(boolean isValid, Principal user) {
            this.isValid = isValid;
            this.user = user;
        }

        public boolean isValid() {
            return isValid;
        }

        public Principal getUser() {
            return user;
        }
    }

    public CredentialValidationResult validate(String username, String password) {
        if (AUTHORIZED_USERS.contains(username) && password.equals("password")) {
            return new CredentialValidationResult(true, new Principal() {
                @Override
                public String getName() {
                    return username;
                }
            });
        } else {
            return new CredentialValidationResult(false, null);
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        CredentialValidationResult result = validator.validate("user1", "password");

        if (result.isValid()) {
            System.out.println("Access granted to " + result.getUser().getName());
        } else {
            System.out.println("Access denied");
        }
    }
}