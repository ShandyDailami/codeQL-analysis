public class java_37206_CredentialValidator_A07 {

    // Predefined pattern for a password
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])";

    public boolean validatePassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test passwords
        String[] passwords = {"password", "Password", "Password1", "Password@", "Password#"};
        for (String password : passwords) {
            if (validator.validatePassword(password)) {
                System.out.println("Password '" + password + "' is valid.");
            } else {
                System.out.println("Password '" + password + "' is invalid.");
            }
        }
    }
}