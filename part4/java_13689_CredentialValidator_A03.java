public class java_13689_CredentialValidator_A03 {

    // A list of predefined credentials
    private static final List<Credential> CREDENTIALS = Arrays.asList(
            new Credential("user1", "password1"),
            new Credential("user2", "password2"),
            new Credential("user3", "password3"));

    public boolean validate(String username, String password) {
        // Iterate over the predefined credentials
        for (Credential credential : CREDENTIALS) {
            // If the username and password match a credential, return true
            if (credential.getUsername().equals(username) && credential.getPassword().equals(password)) {
                return true;
            }
        }
        // If no match found, return false
        return false;
    }

    // Inner class to represent a credential
    public static class Credential {
        private String username;
        private String password;

        public java_13689_CredentialValidator_A03(String username, String password) {
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
}