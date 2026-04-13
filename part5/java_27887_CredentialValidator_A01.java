public class java_27887_CredentialValidator_A01 {
    // Define the password strength criteria
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 16;
    private static final int MIN_UPPERCASE = 1;
    private static final int MIN_LOWERCASE = 1;
    private static final int MIN_NUMBER = 1;
    private static final int MIN_SPECIAL_CHARACTER = 1;

    public boolean isValidPassword(String password) {
        // Check password length
        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            return false;
        }

        // Check for password strength
        int uppercaseCount = 0, lowercaseCount = 0, numberCount = 0, specialCharacterCount = 0;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercaseCount++;
            } else if (Character.isLowerCase(c)) {
                lowercaseCount++;
            } else if (Character.isDigit(c)) {
                numberCount++;
            } else {
                specialCharacterCount++;
            }
        }

        if (uppercaseCount < MIN_UPPERCASE || 
            lowercaseCount < MIN_LOWERCASE || 
            numberCount < MIN_NUMBER || 
            specialCharacterCount < MIN_SPECIAL_CHARACTER) {
            return false;
        }

        return true;
    }
}