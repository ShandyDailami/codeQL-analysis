public class java_09579_CredentialValidator_A01 {

    public static boolean isPasswordStrong(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test the CredentialValidator
        System.out.println(isPasswordStrong("aA1aA1A1")); // Should print true
        System.out.println(isPasswordStrong("password")); // Should print false
    }
}