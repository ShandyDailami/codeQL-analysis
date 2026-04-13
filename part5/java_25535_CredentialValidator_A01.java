public class java_25535_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public boolean validate(String password) {
        // check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // check if password contains uppercase and lowercase letters
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            }
            if (hasUpperCase && hasLowerCase) {
                break;
            }
        }
        if (!hasUpperCase || !hasLowerCase) {
            return false;
        }

        // check if password contains a digit
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
                break;
            }
        }
        if (!hasDigit) {
            return false;
        }

        // if all checks pass, password is considered strong
        return true;
    }

}