public class java_36235_CredentialValidator_A08 {

    // Hardcoded set of credentials
    private static String[][] credentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
        {"user4", "password4"}
    };

    // Method to validate the credentials
    public boolean validate(String username, String password) {
        for (String[] credential : credentials) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing the validator
        boolean isValid = validator.validate("user1", "password1");
        System.out.println("Is valid: " + isValid);

        isValid = validator.validate("user5", "password5");
        System.out.println("Is valid: " + isValid);
    }
}