public class java_25706_CredentialValidator_A01 {

    // Validate password strength
    public static boolean validatePassword(String password) {
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

    // Credential validator
    public static class CredentialValidatorImpl implements CredentialValidator {
        @Override
        public boolean validate(String userName, String password) {
            return validatePassword(password);
        }
    }

    // Main method
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidatorImpl();
        System.out.println(validator.validate("user", "password")); // should print true
        System.out.println(validator.validate("user", "passw")); // should print false
    }
}