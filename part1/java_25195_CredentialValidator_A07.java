public class java_25195_CredentialValidator_A07 {

    // Define a User object
    public class User {
        private String username;
        private String password;

        public java_25195_CredentialValidator_A07(String username, String password) {
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

    // Define a AuthenticationManager object
    public class AuthenticationManager {
        public boolean authenticate(String username, String password) {
            // Simulated authentication
            return username != null && username.equals(password);
        }
    }

    // Define CredentialValidator object
    public class CredentialValidator {
        private AuthenticationManager authenticationManager;

        public java_25195_CredentialValidator_A07(AuthenticationManager authenticationManager) {
            this.authenticationManager = authenticationManager;
        }

        public boolean validate(User user) {
            if (user == null) {
                throw new IllegalArgumentException("User cannot be null");
            }
            return authenticationManager.authenticate(user.getUsername(), user.getPassword());
        }
    }

    // Main method
    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager();
        CredentialValidator credentialValidator = new CredentialValidator(authenticationManager);

        User user = new User("admin", "password");
        boolean isValid = credentialValidator.validate(user);

        System.out.println("Is valid: " + isValid);
    }
}