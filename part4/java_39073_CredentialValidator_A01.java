public class java_39073_CredentialValidator_A01 {

    // Define a list of pre-defined credentials
    private static List<Credential> credentials;

    // Initialize the list of pre-defined credentials
    static {
        credentials = new ArrayList<>();
        credentials.add(new Credential("user1", "pass1"));
        credentials.add(new Credential("user2", "pass2"));
        credentials.add(new Credential("user3", "pass3"));
    }

    // Credential class
    public static class Credential {
        private String username;
        private String password;

        public java_39073_CredentialValidator_A01(String username, String password) {
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

    // CredentialValidator class
    public static class CredentialValidator {
        // Method to validate the provided username and password
        public boolean validate(String username, String password) {
            for (Credential credential : credentials) {
                if (credential.getUsername().equals(username) && credential.getPassword().equals(password)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validator
        boolean isValid = validator.validate("user1", "pass1");
        System.out.println("Is valid? " + isValid); // Should print true

        isValid = validator.validate("wrong_user", "pass1");
        System.out.println("Is valid? " + isValid); // Should print false
    }
}