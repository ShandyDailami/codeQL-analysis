public class java_41342_CredentialValidator_A07 {
    // Hardcoded values, for simplicity
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // No external libraries or frameworks required

    public boolean isValid(String inputUsername, String inputPassword) {
        // No input validation required, as the example only uses hardcoded values

        // Check if input values are correct
        return inputUsername.equals(USERNAME) && inputPassword.equals(PASSWORD);
    }
}