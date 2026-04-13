public class java_30541_CredentialValidator_A03 {

    // Define a static username and password
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        // Check if the provided username and password match the static ones
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("Validated successfully");
            return true;
        } else {
            System.out.println("Invalid credentials");
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validation with some credentials
        LegacyCredentialValidator.validate("user", "password");
    }
}