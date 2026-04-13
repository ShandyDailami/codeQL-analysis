public class java_17240_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public boolean validate(String username, String password) {
        // Here we're assuming a simple rule: the password must be at least 8 characters long,
        // and it must contain at least one uppercase letter, one lowercase letter, and one number.
        if (password == null || password.length() < 8) {
            return false;
        }

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
            if (hasUpperCase && hasLowerCase && hasDigit) {
                return true;
            }
        }

        return false;
    }
}