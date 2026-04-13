import java.security.InvalidParameterException;

public class java_08136_CredentialValidator_A07 {

    // Class to hold credential information
    public static class Credential {
        private String username;
        private String password;

        public java_08136_CredentialValidator_A07(String username, String password) {
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

    // Interface for credential validator
    public interface CredentialValidator {
        boolean isValid(Credential credential);
    }

    // Credential validator that checks if username is 'admin' and password is 'password'
    public static class AdminCredentialValidator implements CredentialValidator {
        public boolean isValid(Credential credential) {
            return credential.getUsername().equals("admin") && credential.getPassword().equals("password");
        }
    }

    // Credential validator that checks if username is a valid email and password is a valid password
    public static class EmailCredentialValidator implements CredentialValidator {
        public boolean isValid(Credential credential) {
            // In a real application, you'd use a regular expression to check if the username is a valid email
            // This is just a placeholder, as the requirement is not about a real email validation
            if (!credential.getUsername().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                return false;
            }
            if (!credential.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*]).{8,}$")) {
                return false;
            }
            return true;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Credential credential = new Credential("admin", "password");

        CredentialValidator validator1 = new AdminCredentialValidator();
        CredentialValidator validator2 = new EmailCredentialValidator();

        validateCredentials(credential, validator1);
        validateCredentials(credential, validator2);
    }

    // Method to validate credentials
    public static void validateCredentials(Credential credential, CredentialValidator validator) {
        if (validator.isValid(credential)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}