public class java_12040_CredentialValidator_A08 {

    // This method verifies if the user's password matches the password in the database
    public boolean validate(String enteredPassword, String correctPassword) {
        return enteredPassword.equals(correctPassword);
    }

    // This method adds a hash to the user's password to prevent password reuse
    public String hashPassword(String password) {
        return password; // Replace with hashed password
    }

    // This method verifies if the user's password is strong enough (currently it just checks if password is at least 8 characters long)
    public boolean isStrongPassword(String password) {
        return password.length() >= 8;
    }

    // This method verifies if the user's email is valid (currently it just checks if it contains '@' symbol)
    public boolean isValidEmail(String email) {
        return email.contains("@");
    }
}