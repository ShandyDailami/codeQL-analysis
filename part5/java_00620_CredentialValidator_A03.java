public class java_00620_CredentialValidator_A03 {

    // Predefined valid credentials
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    // Credentials to be checked against
    private String providedUsername;
    private String providedPassword;

    public java_00620_CredentialValidator_A03(String providedUsername, String providedPassword) {
        this.providedUsername = providedUsername;
        this.providedPassword = providedPassword;
    }

    // Method to validate the provided credentials
    public boolean validate() {
        return isValidUsername() && isValidPassword();
    }

    // Methods to check if provided credentials are valid
    private boolean isValidUsername() {
        return VALID_USERNAME.equals(providedUsername);
    }

    private boolean isValidPassword() {
        // In a real-world application, you would probably hash the provided password
        // and compare the hash to the stored hash. However, for simplicity, we're only
        // checking if the provided password matches the expected password.
        return VALID_PASSWORD.equals(providedPassword);
    }
}