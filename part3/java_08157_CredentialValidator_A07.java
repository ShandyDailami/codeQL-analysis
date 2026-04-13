public class java_08157_CredentialValidator_A07 {

    // A list of known usernames and passwords
    private static final List<Credential> knownCredentials = Arrays.asList(
            new Credential("user1", "password1"),
            new Credential("user2", "password2"),
            new Credential("user3", "password3"));

    // Credential to validate
    private Credential credential;

    public java_08157_CredentialValidator_A07(Credential credential) {
        this.credential = credential;
    }

    public boolean isValid() {
        // Verify the credential
        for (Credential known : knownCredentials) {
            if (known.getUsername().equals(credential.getUsername()) && known.getPassword().equals(credential.getPassword())) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test the validator
        CredentialValidator validator = new CredentialValidator(new Credential("unknown", "unknown"));
        if (validator.isValid()) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid credentials");
        }
    }

    // A simple credential class
    private static class Credential {
        private String username;
        private String password;

        public java_08157_CredentialValidator_A07(String username, String password) {
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