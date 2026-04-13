public class java_00294_CredentialValidator_A07 {

    // Define a list of predefined credentials
    private static List<Credential> credentials = new ArrayList<>();

    // Initialize the list with some predefined credentials
    static {
        credentials.add(new Credential("user1", "password1"));
        credentials.add(new Credential("user2", "password2"));
        credentials.add(new Credential("user3", "password3"));
    }

    public static class Credential {
        private String username;
        private String password;

        public java_00294_CredentialValidator_A07(String username, String password) {
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

    public boolean validateCredentials(String username, String password) {
        // Iterate over the list of credentials
        for (Credential credential : credentials) {
            // If the provided username and password match the stored credentials
            if (credential.getUsername().equals(username) && credential.getPassword().equals(password)) {
                return true;
            }
        }
        // If no match found, return false
        return false;
    }
}