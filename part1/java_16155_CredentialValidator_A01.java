public class java_16155_CredentialValidator_A01 {

    public static boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasNumber = false, hasUpperCase = false, hasLowerCase = false, hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (!isValidSpecialCharacter(c)) {
                hasSpecialChar = true;
            }
            if (hasNumber && hasUpperCase && hasLowerCase && hasSpecialChar) {
                break;
            }
        }

        return hasNumber && hasUpperCase && hasLowerCase && hasSpecialChar;
    }

    private static boolean isValidSpecialCharacter(char c) {
        String specialChars = "!@#$%^&*()+=-[]{}|;:',.<>?/";
        return specialChars.indexOf(c) != -1;
    }

    public static void main(String[] args) {
        System.out.println(validatePassword("Aa123456!")); // Should print: true
        System.out.println(validatePassword("Aa123456")); // Should print: false
        System.out.println(validatePassword("Aa")); // Should print: false
        System.out.println(validatePassword("A123456!")); // Should print: false
    }
}