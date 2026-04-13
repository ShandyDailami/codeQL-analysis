public class java_34614_CredentialValidator_A03 {

    // In real use, the usernames and passwords would be stored in a database
    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPassword";

    public static boolean validate(String username, String password) {
        // Sanity checks
        if (username == null || password == null) {
            return false;
        }

        // Compare input with stored credentials
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }

    // For testing purposes
    public static void main(String[] args) {
        boolean isValid = validate("validUser", "validPassword");
        System.out.println("Is valid? " + isValid);

        isValid = validate("invalidUser", "invalidPassword");
        System.out.println("Is valid? " + isValid);
    }
}