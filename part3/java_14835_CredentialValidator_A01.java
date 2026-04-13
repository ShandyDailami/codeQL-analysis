import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_14835_CredentialValidator_A01 {

    // Prevent direct instantiation
    private java_14835_CredentialValidator_A01() {
        throw new UnsupportedOperationException();
    }

    public static class Credential {
        private final String username;
        private final String password;

        public java_14835_CredentialValidator_A01(String username, String password) {
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

    public static class Validator {
        private Map<String, Credential> credentials = new HashMap<>();

        public java_14835_CredentialValidator_A01() {
            credentials.put("user", new Credential("user", "password"));
            credentials.put("admin", new Credential("admin", "password"));
        }

        public boolean validate(String username, String password) {
            Credential credential = credentials.get(username);
            if (credential == null) {
                return false;
            }

            // Decode password and check if it matches the stored password
            byte[] decodedPassword = Base64.getDecoder().decode(credential.getPassword());
            return new String(decodedPassword).equals(password);
        }
    }

    public static void main(String[] args) {
        Validator validator = new Validator();

        // Try to log in with a non-existent user
        System.out.println("Login attempt: " + validator.validate("non-existent-user", "non-existent-password"));

        // Try to log in with a wrong password
        System.out.println("Login attempt: " + validator.validate("admin", "wrong-password"));

        // Try to log in with the correct credentials
        System.out.println("Login attempt: " + validator.validate("admin", "password"));
    }
}