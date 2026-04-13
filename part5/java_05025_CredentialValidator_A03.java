public class java_05025_CredentialValidator_A03 {

    // Define the expected username and password
    private static final String EXPECTED_USERNAME = "admin";
    private static final String EXPECTED_PASSWORD = "password";

    // The CredentialValidator interface in the legacy style does not exist,
    // so this method is used to validate credentials
    public boolean validate(String username, String password) {
        // Check if the entered username and password match the expected ones
        return username.equals(EXPECTED_USERNAME) && password.equals(EXPECTED_PASSWORD);
    }
}