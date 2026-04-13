import java.util.function.Function;

public class java_01747_CredentialValidator_A01 {
    // Function to validate credentials
    public static Function<Credential, String> validateCredentials = credential -> {
        // Simplified example: Validate username and password
        if (credential.getUsername().equals("admin") && credential.getPassword().equals("password")) {
            return "Credentials Valid";
        } else {
            return "Credentials Invalid";
        }
    };

    public static class Credential {
        private String username;
        private String password;

        public java_01747_CredentialValidator_A01(String username, String password) {
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