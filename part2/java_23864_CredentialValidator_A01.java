public class java_23864_CredentialValidator_A01 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            return false;
        }

        boolean hasLowerCase = password.matches(".*[a-z].*");
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecialCharacter = password.matches(".*[" + SPECIAL_CHARACTERS + "].*");

        if (!(hasLowerCase && hasUpperCase && hasDigit && hasSpecialCharacter)) {
            return false;
        }

        return true;
    }
}