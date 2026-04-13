public class java_04118_CredentialValidator_A01 {

    // The validate method checks the password against a pre-set list of hardcoded passwords
    public boolean validate(String password) {
        String[] hardcodedPasswords = {"password1", "password2", "password3", "password4"};

        for (String hardcodedPassword : hardcodedPasswords) {
            if (hardcodedPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }

    // A utility method to hash passwords
    private String hashPassword(String password) {
        // You could use a sophisticated hashing method here, e.g. SHA-256
        // This is just a simple example
        return password;
    }
}