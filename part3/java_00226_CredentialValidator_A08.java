public class java_00226_CredentialValidator_A08 {

    // Private instance of CredentialValidator
    private static CredentialValidator validator;

    // Private constructor to restrict instantiation from outside
    private java_00226_CredentialValidator_A08() {}

    // Public method to get the singleton instance
    public static CredentialValidator getInstance() {
        if (validator == null) {
            validator = new CredentialValidator();
        }
        return validator;
    }

    // Method to validate user credentials
    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}