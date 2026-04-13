public class java_04013_CredentialValidator_A08 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+=-{}[]|\\:;\"'<,>.?/?";

    public boolean isPasswordStrongEnough(String password) {
        if (password == null || password.length() == 0) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (SPECIAL_CHARACTERS.contains(Character.toString(c))) {
                hasSpecialCharacter = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialCharacter) {
                return true;
            }
        }

        return false;
    }
}