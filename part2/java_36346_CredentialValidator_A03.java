public class java_36346_CredentialValidator_A03 {
    public static boolean isPasswordStrong(String password) {
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
        String specialChars = "~!@#$%^&*()_+`={}[]|\\:;\"<>,.?/";
        return specialChars.contains(String.valueOf(c));
    }

    public static void main(String[] args) {
        String password = "ThisIsAStrongPassword1";
        if (isPasswordStrong(password)) {
            System.out.println("Password is strong.");
        } else {
            System.out.println("Password is not strong enough.");
        }
    }
}