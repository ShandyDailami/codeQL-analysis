public class java_18570_CredentialValidator_A01 {
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%^*?&])[A-Za-z0-9@$!%^*?&]{8,}$";

    public boolean isValidPassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing with valid password
        if (validator.isValidPassword("TestPassword@123")) {
            System.out.println("Valid password");
        } else {
            System.out.println("Invalid password");
        }

        // Testing with invalid password (does not match the pattern)
        if (!validator.isValidPassword("InvalidPassword")) {
            System.out.println("Invalid password");
        } else {
            System.out.println("Valid password");
        }
    }
}