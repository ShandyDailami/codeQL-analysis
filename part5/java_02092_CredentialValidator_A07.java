public class java_02092_CredentialValidator_A07 {

    // A method to check the password
    public boolean validatePassword(String password) {

        // Check if the password is not null and has a length greater than 8
        if (password == null || password.length() <= 8) {
            return false;
        }

        // Check if the password contains at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check if the password contains at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check if the password contains at least one digit
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Check if the password contains at least one special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            return false;
        }

        // If all the checks are passed, the password is valid
        return true;
    }
}