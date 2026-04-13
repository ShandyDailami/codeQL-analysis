public class java_24859_CredentialValidator_A07 {

    private static class Credentials {
        private String username;
        private String password;

        public java_24859_CredentialValidator_A07(String username, String password) {
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

    private Credentials credentials;

    public java_24859_CredentialValidator_A07(String username, String password) {
        this.credentials = new Credentials(username, password);
    }

    public boolean isValid() {
        // Simulate a secure authentication process
        // In a real-world scenario, this would require secure storage and retrieval of credentials
        return validateCredentials();
    }

    private boolean validateCredentials() {
        // This method should be replaced with actual authentication logic
        // It could use hashed passwords, database queries, or other secure methods
        return this.credentials.getUsername().equals("admin") && this.credentials.getPassword().equals("password");
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.isValid()) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}