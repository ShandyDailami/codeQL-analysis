public class java_16372_CredentialValidator_A07 {

    // Define a list of credentials
    private static final List<Credential> credentials = new ArrayList<>();

    // Define a Credential class
    public static class Credential {
        private String username;
        private String password;

        public java_16372_CredentialValidator_A07(String username, String password) {
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

    // Static block to initialize the credentials
    static {
        credentials.add(new Credential("user1", "password1"));
        credentials.add(new Credential("user2", "password2"));
        credentials.add(new Credential("user3", "password3"));
    }

    // Method to validate a username and password
    public static boolean validate(String username, String password) {
        // Iterate over the credentials
        for (Credential credential : credentials) {
            // Check if the username and password match
            if (credential.getUsername().equals(username) && credential.getPassword().equals(password)) {
                return true;
            }
        }
        // If the username and password do not match any of the credentials, return false
        return false;
    }

    public static void main(String[] args) {
        // Test the validate method
        System.out.println(validate("user1", "password1")); // true
        System.out.println(validate("user4", "password4")); // false
    }
}