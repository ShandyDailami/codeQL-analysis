public class java_07222_CredentialValidator_A01 {

    // Hardcoded credentials for simplicity
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public void validate(String username, String password) throws InvalidCredentialsException {
        if (!username.equals(USERNAME) || !password.equals(PASSWORD)) {
            throw new InvalidCredentialsException("Invalid username or password");
        }
    }

    // Custom exception for invalid credentials
    public static class InvalidCredentialsException extends Exception {
        public java_07222_CredentialValidator_A01(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        try {
            validator.validate("wrongUsername", "wrongPassword"); // Invalid credentials
        } catch (InvalidCredentialsException e) {
            System.out.println(e.getMessage()); // Prints: Invalid username or password
        }
    }
}