public class java_12552_CredentialValidator_A03 {
    // A very simple validation, only checks if the credentials are not null
    public boolean isValid(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        // For a real-world application, you would want to hash and salt the password
        // and then compare the hashes. This is a simplified example.
        return !(username.equals("admin") && password.equals("password"));
    }

    // This is a placeholder for a more complex validation. It checks if a username is
    // not too long, not too short, and contains a valid character set.
    public boolean isValidUsername(String username) {
        if (username == null) {
            return false;
        }
        // For a real-world application, you would want to check the length of the username
        // and ensure it does not contain any invalid characters. This is a simplified
        // example.
        return username.length() > 5 && !username.contains(" ");
    }

    // Similar validation for the password
    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        // For a real-world application, you would want to ensure the password is strong
        // (it must contain a number, a special character, and a uppercase letter).
        // This is a simplified example.
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])");
    }
}