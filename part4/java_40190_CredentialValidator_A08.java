public class java_40190_CredentialValidator_A08 {

    public static boolean validatePassword(String password) {
        if (password == null || password.length() == 0) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!isSpecialCharacter(c)) {
                hasSpecialChar = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    private static boolean isSpecialCharacter(char c) {
        return !Character.isLetterOrDigit(c) && c != ' ';
    }

    public static void main(String[] args) {
        System.out.println(validatePassword("YourPassword@123")); // true
        System.out.println(validatePassword("yourpassword@123")); // false
        System.out.println(validatePassword("YOURPASSWORD@123")); // false
        System.out.println(validatePassword("YOUR PASSWORD@123")); // false
        System.out.println(validatePassword("YOURPASSWORD@12")); // false
        System.out.println(validatePassword("")); // false
        System.out.println(validatePassword(null)); // false
    }
}