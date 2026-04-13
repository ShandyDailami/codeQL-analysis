public class java_03662_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public boolean validate(String username, String password) {
        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one uppercase letter, one lowercase letter, and one digit
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
            // If all conditions are met, break the loop
            if (hasUpperCase && hasLowerCase && hasDigit) {
                break;
            }
        }

        // If all conditions are met, return true
        return hasUpperCase && hasLowerCase && hasDigit;
    }
}