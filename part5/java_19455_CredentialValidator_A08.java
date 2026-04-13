public class java_19455_CredentialValidator_A08 {

    public boolean validate(String username, String password) {
        // In a real-world scenario, you would actually store the hashed version of the password
        // and compare the hash to a stored hash. This is a simple example of how you might do this.
        // We're just checking for a length of the password and a presence of a digit.
        // In a real-world scenario, the password should not be stored in plain text.
        if (password == null || password.length() == 0) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        if (username == null || username.length() == 0) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        if (!(password.matches(".*[0-9].*"))) {
            throw new IllegalArgumentException("Password must contain a digit");
        }

        if (!(password.matches(".*[A-Z].*"))) {
            throw new IllegalArgumentException("Password must contain an uppercase letter");
        }

        if (!(password.matches(".*[a-z].*"))) {
            throw new IllegalArgumentException("Password must contain a lowercase letter");
        }

        return true;
    }
}