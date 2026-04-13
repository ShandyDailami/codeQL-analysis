public class java_33879_CredentialValidator_A01 {

    private static final String SPECIAL_CHARACTERS = "~`!@#$%^&*()_+={}[]|\\:;\"<>,.?/";

    public boolean validate(String password) {
        if (password == null || password.length() < 8) {
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
            } else if (SPECIAL_CHARACTERS.indexOf(c) != -1) {
                hasSpecialCharacter = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialCharacter) {
                return true;
            }
        }

        return false;
    }
}