public class java_16427_CredentialValidator_A01 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static class Credential {
        private String username;
        private String password;

        public java_16427_CredentialValidator_A01(String username, String password) {
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

    public java_16427_CredentialValidator_A01() {
        // No-op constructor
    }

    public boolean validate(Credential credential) {
        if (credential == null) {
            return false;
        }

        return credential.getUsername().equals(USERNAME) &&
               credential.getPassword().equals(PASSWORD);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        Credential credential = new Credential("admin", "password");
        boolean isValid = validator.validate(credential);

        System.out.println("Is valid: " + isValid);

        credential = new Credential("wrong", "wrong");
        isValid = validator.validate(credential);

        System.out.println("Is valid: " + isValid);
    }
}