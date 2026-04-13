public class java_18431_CredentialValidator_A07 {

    // Define a list of pre-defined credentials
    private static final List<Credential> credentials = new ArrayList<>();

    // Define a Credential class
    public static class Credential {
        private String username;
        private String password;

        public java_18431_CredentialValidator_A07(String username, String password) {
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

    // Initialize the list of credentials
    static {
        credentials.add(new Credential("user1", "password1"));
        credentials.add(new Credential("user2", "password2"));
        credentials.add(new Credential("user3", "password3"));
    }

    // Method to validate the credentials
    public boolean validate(String username, String password) {
        // Iterate over the list of credentials
        for (Credential credential : credentials) {
            // If the credentials match, return true
            if (credential.getUsername().equals(username) && credential.getPassword().equals(password)) {
                return true;
            }
        }
        // If no match is found, return false
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate the credentials
        boolean isValid = validator.validate("user1", "password1");
        System.out.println("Is Valid: " + isValid); // Should print: true

        isValid = validator.validate("user4", "password4");
        System.out.println("Is Valid: " + isValid); // Should print: false
    }
}