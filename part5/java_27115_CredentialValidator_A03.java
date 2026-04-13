public class java_27115_CredentialValidator_A03 {

    // Define the characters we want to accept in the password
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+";
    private static final String NUMBERS = "0123456789";

    // Method to validate the password
    public boolean validatePassword(String password) {
        // Check if the password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if the password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check if the password contains at least one uppercase letter, one lowercase letter, one special character and one number
        if (!hasUpperCase(password) || !hasLowerCase(password) || !hasNumber(password) || !hasSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    // Method to check if the password contains at least one uppercase letter
    private boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    // Method to check if the password contains at least one lowercase letter
    private boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    // Method to check if the password contains at least one number
    private boolean hasNumber(String password) {
        return password.matches(".*[0-9].*");
    }

    // Method to check if the password contains at least one special character
    private boolean hasSpecialCharacter(String password) {
        return password.matches(".*[" + SPECIAL_CHARACTERS + "].*");
    }
}