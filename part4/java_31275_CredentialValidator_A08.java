public class java_31275_CredentialValidator_A08 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+={}[]|\\:;<>,.?/~`";

    public static boolean isValidPassword(String password) {
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
            } else if (SPECIAL_CHARACTERS.indexOf(c) != -1) {
                hasSpecialCharacter = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialCharacter) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // You can test the validator with a variety of passwords
        System.out.println(isValidPassword("Password123"));  // Returns true
        System.out.println(isValidPassword("password123"));  // Returns false
        System.out.println(isValidPassword("PassW0rd123"));  // Returns true
        System.out.println(isValidPassword("123PassW0rd123"));  // Returns true
        System.out.println(isValidPassword("123Password@"));  // Returns true
        System.out.println(isValidPassword("123Password123"));  // Returns false
    }
}