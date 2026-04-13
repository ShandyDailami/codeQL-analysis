public class java_17742_CredentialValidator_A01 {
    public static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public boolean validatePassword(String password) {
        if (password == null || password.length() < 8 || password.length() > 20) {
            return false;
        }

        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasLowerCase = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecialChar = password.matches(".*[" + SPECIAL_CHARACTERS + "].*");

        if (!(hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar)) {
            return false;
        }

        return true;
    }
}