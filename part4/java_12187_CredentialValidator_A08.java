public class java_12187_CredentialValidator_A08 {
    // This method checks if the password is strong enough.
    public boolean isPasswordStrongEnough(String password) {
        // A strong password is at least 8 characters long, contains uppercase and lowercase letters, and a digit.
        if (password.length() < 8) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        return true;
    }

    // This method checks if the username is valid.
    public boolean isUsernameValid(String username) {
        // A valid username is at least 3 characters long and contains only alphanumeric characters.
        if (username.length() < 3) {
            return false;
        }
        if (!username.matches(".*[A-Za-z0-9].*")) {
            return false;
        }
        return true;
    }

    // This method validates the login.
    public boolean validateLogin(String username, String password) {
        if (!isUsernameValid(username)) {
            // If the username is not valid, print an error message and return false.
            System.out.println("Invalid username");
            return false;
        }
        if (!isPasswordStrongEnough(password)) {
            // If the password is not strong enough, print an error message and return false.
            System.out.println("Password is not strong enough");
            return false;
        }
        // If both username and password are valid, print a success message and return true.
        System.out.println("Login successful");
        return true;
    }
}