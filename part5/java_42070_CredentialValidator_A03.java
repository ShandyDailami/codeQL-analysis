public class java_42070_CredentialValidator_A03 {

    // This method validates if a password meets certain criteria
    public boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasLowerCase = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecialCharacter = password.matches(".*[@$%^&*(),.?\\{\\},|<>].*");

        if (!(hasUpperCase && hasLowerCase && hasDigit && hasSpecialCharacter)) {
            return false;
        }

        return true;
    }

    // This method validates if a username and password combination are valid
    public boolean validateCredentials(String username, String password) {
        if (username == null || password == null || username.length() == 0 || password.length() == 0) {
            return false;
        }

        // Here we are using this method to check if the password is valid, if not, it will return false
        return validatePassword(password);
    }
}