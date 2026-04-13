public class java_35513_CredentialValidator_A01 {

    public static boolean checkPassword(String password) {
        // Simulates a password check
        // In a real-world application, you'd use a stronger method of checking passwords
        // This example doesn't actually use passwords, it's just a placeholder

        // Simulate a random password
        if (password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static CredentialValidator getInstance() {
        // This is a placeholder for a real CredentialValidator
        // In a real-world application, you'd use a real CredentialValidator implementation
        // This example doesn't actually use CredentialValidators, it's just a placeholder
        return new CredentialValidator() {
            @Override
            public boolean validate(String password) {
                // Simulates a real CredentialValidator
                // In a real-world application, you'd use a stronger validation method (e.g., LDAP)
                // This example doesn't actually use CredentialValidators, it's just a placeholder

                return checkPassword(password);
            }
        };
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = getInstance();
        boolean result = validator.validate("password");
        System.out.println("Password is valid: " + result);
    }
}