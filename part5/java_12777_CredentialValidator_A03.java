public class java_12777_CredentialValidator_A03 {
    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        // Checking for at least one uppercase, one lowercase, one digit, one special character
        boolean hasUpperCase = password.matches("(?=.*[A-Z])");
        boolean hasLowerCase = password.matches("(?=.*[a-z])");
        boolean hasDigit = password.matches("(?=.*[0-9])");
        boolean hasSpecialChar = password.matches("(?=.*[@#$%^&*])");
        boolean isValidLength = password.length() >= 8;

        if (!(hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar && isValidLength)) {
            return false;
        }

        return true;
    }
}