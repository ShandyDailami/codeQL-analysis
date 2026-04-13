public class java_27033_CredentialValidator_A03 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String SPECIAL_CHARACTERS_SET = "!@#$%^&*()";

    // Method to validate if a password matches a certain pattern
    public boolean validate(String password) {
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (SPECIAL_CHARACTERS_SET.contains(c)) {
                hasSpecialCharacter = true;
            }

            if (hasLowerCase && hasUpperCase && hasDigit && hasSpecialCharacter) {
                return true;
            }
        }

        return false;
    }
}