public class java_41192_CredentialValidator_A08 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String SPECIAL_CHARACTERS_LIST = "!@#$%^&*()";

    public boolean validate(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        int digitCount = 0;
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int specialCharacterCount = 0;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            } else if (Character.isUpperCase(c)) {
                upperCaseCount++;
            } else if (Character.isLowerCase(c)) {
                lowerCaseCount++;
            } else if (SPECIAL_CHARACTERS_LIST.contains(c)) {
                specialCharacterCount++;
            }
        }

        return digitCount > 0 && upperCaseCount > 0 && lowerCaseCount > 0 && specialCharacterCount > 0;
    }
}