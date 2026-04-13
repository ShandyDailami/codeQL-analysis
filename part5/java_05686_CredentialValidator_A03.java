import java.security.Principal;

public class java_05686_CredentialValidator_A03 {

    public static class Credentials {
        private String username;
        private String password;

        public java_05686_CredentialValidator_A03(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public static class ValidationResult {
        private Principal principal;
        private boolean valid;

        public java_05686_CredentialValidator_A03(Principal principal, boolean valid) {
            this.principal = principal;
            this.valid = valid;
        }

        public Principal getPrincipal() {
            return principal;
        }

        public boolean isValid() {
            return valid;
        }
    }

    public ValidationResult validate(Credentials credentials) {
        // You should not use a hard-coded username or password in your validation logic.
        // This is a placeholder, it just returns a dummy principal if the username is correct.

        if ("correct_username".equals(credentials.getUsername())) {
            return new ValidationResult(credentials.getUsername(), true);
        } else {
            return new ValidationResult(credentials.getUsername(), false);
        }
    }
}