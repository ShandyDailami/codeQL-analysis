public class java_23123_CredentialValidator_A01 {
    public static boolean isPasswordStrong(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            return false;
        }

        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digit = false;
        boolean specialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCase = true;
            } else if (Character.isLowerCase(c)) {
                lowerCase = true;
            } else if (Character.isDigit(c)) {
                digit = true;
            } else {
                specialChar = true;
            }

            if (upperCase && lowerCase && digit && specialChar) {
                return true;
            }
        }

        return false;
    }
}