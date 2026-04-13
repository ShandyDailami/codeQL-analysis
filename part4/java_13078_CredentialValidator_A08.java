public class java_13078_CredentialValidator_A08 {
    public static boolean validatePassword(String password) {
        // Checking if the password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Checking if the password has a mix of uppercase, lowercase, numbers and special characters
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasLowerCase = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*(),.?\":{}|<>]*");

        if (!hasUpperCase || !hasLowerCase || !hasDigit || !hasSpecialChar) {
            return false;
        }

        return true;
    }
}