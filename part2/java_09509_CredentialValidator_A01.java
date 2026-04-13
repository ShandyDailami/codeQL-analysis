public class java_09509_CredentialValidator_A01 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+={}[]|\\:<>,.?/~`";
    private static final String SPECIAL_CHARACTERS_SET = SPECIAL_CHARACTERS.replace(" ", "");

    public static boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false, hasLowerCase = false, hasDigit = false, hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (SPECIAL_CHARACTERS_SET.indexOf(c) != -1) {
                hasSpecialChar = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }
}