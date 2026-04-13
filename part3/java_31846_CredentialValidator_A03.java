public class java_31846_CredentialValidator_A03 {

    // Credential class that stores properties
    public static class Credential {
        private String username;
        private String password;

        public java_31846_CredentialValidator_A03(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // getters and setters are not shown for brevity
    }

    // CredentialValidator class
    public static class CredentialValidator {
        public boolean validate(Credential credential) {
            // Here's where you would add your specific security-sensitive operations
            // For example, you might check the length of the password
            if (credential.password.length() < 8) {
                return false;
            }

            // If we've made it past the length check, we're good
            return true;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // This is a test Credential
        Credential testCredential = new Credential("test", "short");

        if (validator.validate(testCredential)) {
            System.out.println("Credential validated successfully.");
        } else {
            System.out.println("Credential failed validation.");
        }
    }
}