public class java_01122_CredentialValidator_A07 {

    // Define a predefined list of credentials
    private static List<Credential> credentials = Arrays.asList(
        new Credential("user1", "password1"),
        new Credential("user2", "password2"),
        new Credential("user3", "password3")
    );

    // Credential class
    public static class Credential {
        private String username;
        private String password;

        public java_01122_CredentialValidator_A07(String username, String password) {
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

    // Method to validate credentials
    public static boolean validateCredentials(String username, String password) {
        for (Credential credential : credentials) {
            if (credential.getUsername().equals(username) && credential.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test the credentials
        System.out.println("Is user1 valid? " + (validateCredentials("user1", "password1") ? "Yes" : "No"));
        System.out.println("Is user4 valid? " + (validateCredentials("user4", "password4") ? "Yes" : "No"));
    }
}