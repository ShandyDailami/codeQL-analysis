public class java_24910_CredentialValidator_A08 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        int digitCount = 0, upperCaseCount = 0, specialCharCount = 0;

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

    public static void main(String[] args) {
        System.out.println(isValidPassword("Aa12345!")); // Output: true
        System.out.println(isValidPassword("A12345!")); // Output: false
    }
}