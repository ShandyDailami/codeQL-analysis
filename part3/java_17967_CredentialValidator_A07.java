public class java_17967_CredentialValidator_A07 implements CredentialValidator {

    // This method will be called by the CredentialValidatorService to validate a username and password.
    @Override
    public boolean validate(Credential c) throws InvalidCredentialException {

        // Checking if password is null
        if (c.getPassword() == null) {
            throw new InvalidCredentialException("Password cannot be null");
        }

        // Checking if password is too short
        if (c.getPassword().length() < 8) {
            throw new InvalidCredentialException("Password must be at least 8 characters long");
        }

        // Checking if password contains uppercase letters
        if (!hasUpperCase(c.getPassword())) {
            throw new InvalidCredentialException("Password must contain at least one uppercase letter");
        }

        // Checking if password contains lowercase letters
        if (!hasLowerCase(c.getPassword())) {
            throw new InvalidCredentialException("Password must contain at least one lowercase letter");
        }

        // Checking if password contains numbers
        if (!hasDigit(c.getPassword())) {
            throw new InvalidCredentialException("Password must contain at least one number");
        }

        // Checking if password contains special characters
        if (!hasSpecialCharacter(c.getPassword())) {
            throw new InvalidCredentialException("Password must contain at least one special character");
        }

        // If all checks are passed
        return true;
    }

    // Method to check if a string has an uppercase letter
    private boolean hasUpperCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i)))
                return true;
        }
        return false;
    }

    // Method to check if a string has a lowercase letter
    private boolean hasLowerCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i)))
                return true;
        }
        return false;
    }

    // Method to check if a string has a digit
    private boolean hasDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)))
                return true;
        }
        return false;
    }

    // Method to check if a string has a special character
    private boolean hasSpecialCharacter(String str) {
        // Here you can add special characters to check
        return str.matches(".*[!@#$%^&*()_+-={}\\[\\]:\";'?,.<>]+.*");
    }
}