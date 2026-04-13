public class java_15014_CredentialValidator_A01 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasUpperCase = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                hasSpecialChar = true;
            }

            if (hasDigit && hasUpperCase && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }
}