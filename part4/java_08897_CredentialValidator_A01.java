public class java_08897_CredentialValidator_A01 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public static boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false, hasLowerCase = false, hasNumber = false, hasSpecialCharacter = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (SPECIAL_CHARACTERS.indexOf(c) != -1) {
                hasSpecialCharacter = true;
            }
            if (hasUpperCase && hasLowerCase && hasNumber && hasSpecialCharacter) {
                return true;
            }
        }
        return false;
    }
}