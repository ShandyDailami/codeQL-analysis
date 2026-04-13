public class java_34031_CredentialValidator_A07 {
    // Hardcoded set of credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate credentials
    public boolean validate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Username and password to validate
        String username = "admin";
        String password = "password";

        if (validator.validate(username, password)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}