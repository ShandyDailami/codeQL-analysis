public class java_09476_CredentialValidator_A01 {
    private static final String VALID_PASSWORD = "password";

    public static class Credential {
        private String username;
        private String password;

        public java_09476_CredentialValidator_A01(String username, String password) {
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

    public static CredentialValidator.CredentialValidatorResult validate(Credential credential) {
        if (credential.getPassword().equals(VALID_PASSWORD)) {
            return CredentialValidator.CredentialValidatorResult.VALID;
        } else {
            return CredentialValidator.CredentialValidatorResult.INVALID;
        }
    }

    public static void main(String[] args) {
        Credential credential = new Credential("user", "password");
        CredentialValidator.CredentialValidatorResult result = validate(credential);

        if (result == CredentialValidator.CredentialValidatorResult.VALID) {
            System.out.println("Access granted for user " + credential.getUsername());
        } else {
            System.out.println("Access denied for user " + credential.getUsername());
        }
    }
}