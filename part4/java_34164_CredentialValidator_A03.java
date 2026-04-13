public class java_34164_CredentialValidator_A03 {
    public static boolean validatePassword(String password) {
        // Check for at least 8 characters
        if (password.length() < 8) {
            return false;
        }

        // Check for uppercase letter
        boolean hasUpperCase = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                hasUpperCase = true;
                break;
            }
        }
        // Check for lowercase letter
        boolean hasLowerCase = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                hasLowerCase = true;
                break;
            }
        }
        // Check for number
        boolean hasNumber = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.getNumericValue(password.charAt(i)) >= 0 && Character.getNumericValue(password.charAt(i)) <= 9) {
                hasNumber = true;
                break;
            }
        }

        // All checks passed, return true
        return (hasUpperCase && hasLowerCase && hasNumber);
    }
}