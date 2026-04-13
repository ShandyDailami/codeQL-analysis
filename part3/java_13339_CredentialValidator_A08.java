public class java_13339_CredentialValidator_A08 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public boolean isValid(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        boolean hasUpperCase = containsUpperCase(password);
        boolean hasLowerCase = containsLowerCase(password);
        boolean hasDigit = containsDigit(password);
        boolean hasSpecialCharacter = containsSpecialCharacter(password);

        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialCharacter;
    }

    private boolean containsUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean containsLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private boolean containsDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    private boolean containsSpecialCharacter(String password) {
        return password.matches(".*[" + SPECIAL_CHARACTERS + "].*");
    }
}