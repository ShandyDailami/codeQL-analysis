public class java_30119_CredentialValidator_A03 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        int digitCount = 0;
        int upperCaseCount = 0;
        int specialCharCount = 0;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            } else if (Character.isUpperCase(c)) {
                upperCaseCount++;
            } else if (SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                specialCharCount++;
            }
        }

        return digitCount > 0 && upperCaseCount > 0 && specialCharCount > 0;
    }
}