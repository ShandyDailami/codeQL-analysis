public class java_28082_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public ValidationResult validate(String password) {
        ValidationResult result = new ValidationResult();

        // Check password length
        if (password.length() < 8) {
            result.setValid(false);
            result.setErrorMessage("Password should be at least 8 characters long");
            return result;
        }

        // Check for uppercase, lowercase, digit and special character
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpperCase = true;
            if (Character.isLowerCase(c)) hasLowerCase = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (!Character.isLetterOrDigit(c)) hasSpecialChar = true;
            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) break;
        }

        if (!hasUpperCase) {
            result.setValid(false);
            result.setErrorMessage("Password should have at least one upper case letter");
        } else if (!hasLowerCase) {
            result.setValid(false);
            result.setErrorMessage("Password should have at least one lower case letter");
        } else if (!hasDigit) {
            result.setValid(false);
            result.setErrorMessage("Password should have at least one digit");
        } else if (!hasSpecialChar) {
            result.setValid(false);
            result.setErrorMessage("Password should have at least one special character");
        } else {
            result.setValid(true);
        }

        return result;
    }

}