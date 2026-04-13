public class java_29129_CredentialValidator_A07 {
    // Private field to store the user's password
    private String password;

    // Constructor to initialize the password
    public java_29129_CredentialValidator_A07(String password) {
        this.password = password;
    }

    // Method to validate the password
    public boolean validatePassword(String passwordToCheck) {
        // If the passwords match, return true
        if (password.equals(passwordToCheck)) {
            return true;
        }

        // Otherwise, return false
        return false;
    }
}