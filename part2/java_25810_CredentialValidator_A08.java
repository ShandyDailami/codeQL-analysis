public class java_25810_CredentialValidator_A08 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+";

    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        int digitCount = 0;
        int lowercaseCount = 0;
        int uppercaseCount = 0;
        int specialCharCount = 0;

        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                digitCount++;
            } else if (Character.isLowerCase(ch)) {
                lowercaseCount++;
            } else if (Character.isUpperCase(ch)) {
                uppercaseCount++;
            } else if (SPECIAL_CHARACTERS.contains(Character.toString(ch))) {
                specialCharCount++;
            }
        }

        return digitCount > 0 && lowercaseCount > 0 && uppercaseCount > 0 && specialCharCount > 0;
    }
}