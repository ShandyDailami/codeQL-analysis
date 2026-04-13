public class java_33218_CredentialValidator_A08 {
    // Storing known credentials
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    // Method to check credentials
    public boolean validate(String inputUsername, String inputPassword) {
        // If the input credentials match the known ones, return true
        if (inputUsername.equals(USERNAME) && inputPassword.equals(PASSWORD)) {
            return true;
        } else {
            // If the input credentials do not match the known ones, return false
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing the validator
        System.out.println(validator.validate("user", "pass"));  // True
        System.out.println(validator.validate("wrong", "user"));  // False
        System.out.println(validator.validate("user", "wrong"));  // False
        System.out.println(validator.validate("user", "pass"));  // True
    }
}