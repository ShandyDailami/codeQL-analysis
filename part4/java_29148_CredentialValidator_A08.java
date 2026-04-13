public class java_29148_CredentialValidator_A08 {

    // Simple validation
    public void validate(String username, String password) {
        if (!username.equals("admin") || !password.equals("password")) {
            throw new IntegrityFailureException("Invalid username or password");
        }
    }

    // Custom exception class
    class IntegrityFailureException extends RuntimeException {
        public java_29148_CredentialValidator_A08(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("admin", "password"); // This should work fine
        validator.validate("wrong_username", "password"); // This should throw an exception
        validator.validate("admin", "wrong_password"); // This should throw an exception
    }
}