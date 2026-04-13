public class java_29534_CredentialValidator_A07 {

    private static final String[][] credentials = {
        {"user1", "pass1"},
        {"user2", "pass2"},
        {"user3", "pass3"}
    };

    public static CredentialResult validate(String username, String password) {
        for (String[] credential : credentials) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return new CredentialResult(true, "Authentication successful");
            }
        }
        return new CredentialResult(false, "Invalid username or password");
    }

    public static class CredentialResult {
        private final boolean isValid;
        private final String message;

        public java_29534_CredentialValidator_A07(boolean isValid, String message) {
            this.isValid = isValid;
            this.message = message;
        }

        public boolean isValid() {
            return isValid;
        }

        public String getMessage() {
            return message;
        }
    }

    public static void main(String[] args) {
        CredentialResult result = validate("user1", "pass1");
        if (result.isValid()) {
            System.out.println(result.getMessage());
        } else {
            System.out.println(result.getMessage());
        }
    }
}