import java.security.Principal;

public class java_39074_CredentialValidator_A03 {

    // Step 1: Create a interface for a principal with the necessary methods
    public interface Principal {
        String getName();
        String getPassword();
    }

    // Step 2: Implement the CredentialValidator interface
    public class Implementation implements CredentialValidator.Principal {

        private Principal principal;

        public java_39074_CredentialValidator_A03(Principal principal) {
            this.principal = principal;
        }

        @Override
        public String getName() {
            return principal.getName();
        }

        @Override
        public String getPassword() {
            return principal.getPassword();
        }

        // Step 3: Implement the method to validate the credentials
        public boolean validateCredentials(String username, String password) {
            // This is a dummy method. Replace with your own validation logic
            return this.getName().equals(username) && this.getPassword().equals(password);
        }
    }
}