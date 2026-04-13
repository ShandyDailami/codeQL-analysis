public class java_21286_CredentialValidator_A01 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasNumber = false, hasUpperCase = false, hasLowerCase = false, hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (SPECIAL_CHARACTERS.indexOf(c) != -1) {
                hasSpecialCharacter = true;
            }

            if (hasNumber && hasUpperCase && hasLowerCase && hasSpecialCharacter) {
                return true;
            }
        }

        return false;
    }

}