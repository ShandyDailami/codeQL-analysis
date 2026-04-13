public class java_29823_CredentialValidator_A01 implements CredentialValidator {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBERS = "0123456789";

    @Override
    public ValidationResult validate(String username, String password) {
        if (password == null || password.isEmpty()) {
            return ValidationResult.failure("Password cannot be empty");
        }

        if (!(hasUpperCase(password) && hasLowerCase(password) && hasNumber(password) && hasSpecialCharacter(password))) {
            return ValidationResult.failure("Password should have at least one upper case, one lower case, one number and one special character");
        }

        return ValidationResult.success("Password is valid");
    }

    private boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private boolean hasNumber(String password) {
        return password.matches(".*[0-9].*");
    }

    private boolean hasSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}