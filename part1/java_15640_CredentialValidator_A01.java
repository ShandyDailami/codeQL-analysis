public class java_15640_CredentialValidator_A01 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+=";

    public static boolean isStrongPassword(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
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
        }

        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialCharacter;
    }

    public static void main(String[] args) {
        System.out.println(isStrongPassword("Password@123")); // Should print true
        System.out.println(isStrongPassword("password")); // Should print false
    }
}