public class java_40954_CredentialValidator_A03 {

    // Predefined pattern for password
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).+$";

    public boolean validatePassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing the validator
        String password = "Password1!";
        if (validator.validatePassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }
}