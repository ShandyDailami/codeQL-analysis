public class java_15890_CredentialValidator_A01 {

    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = false;

        char[] chars = password.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (!"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".indexOf(c) != -1) {
                hasSpecialChar = true;
            }

            if (hasDigit && hasUpperCase && hasLowerCase && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("A01_BrokenAccessControl12345")); // prints true
        System.out.println(isValidPassword("A01_BrokenAccessControl")); // prints false
        System.out.println(isValidPassword("password")); // prints false
    }
}