public class java_07730_CredentialValidator_A08 {

    // Use only the Java Standard Libraries

    // Import necessary classes
    import java.security.MessageDigest;
    import java.security.NoSuchAlgorithmException;

    public class Credential {
        // Declare necessary fields
        private String username;
        private String password;

        // Constructor
        public java_07730_CredentialValidator_A08(String username, String password) {
            this.username = username;
            this.password = hashPassword(password);
        }

        // Getters
        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        // Hash the password method
        private String hashPassword(String password) {
            MessageDigest md;
            try {
                md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(password.getBytes());
                return new String(hash);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }

        // Compare two credentials method
        public boolean compareCredentials(Credential other) {
            return this.username.equals(other.getUsername()) &&
                    this.password.equals(other.getPassword());
        }
    }

    public class CredentialValidator {
        // Compare two credentials method
        public boolean compareCredentials(Credential validator, Credential user) {
            return validator.compareCredentials(user);
        }
    }
}