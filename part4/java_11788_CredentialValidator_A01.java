public class java_11788_CredentialValidator_A01 {

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
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }
        }

        if (!hasUpperCase || !hasLowerCase || !hasDigit || !hasSpecialChar) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStrongPassword("YourPassword@123")); // returns true
        System.out.println(isStrongPassword("yourpassword123")); // returns false
        System.out.println(isStrongPassword("PASSWORD123")); // returns false
    }
}