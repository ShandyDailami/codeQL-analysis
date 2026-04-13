public class java_14995_CredentialValidator_A03 {
    public static boolean isPasswordSecure(String password) {
        boolean hasSpecialChar = false;

        // Check if password contains any special character
        for (char c : password.toCharArray()) {
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == ' ')) {
                hasSpecialChar = true;
                break;
            }
        }

        // Check if password is at least 8 characters long and contains at least one digit, one uppercase and one lowercase letter
        if (password.length() < 8 || !hasSpecialChar || !password.matches(".*[0-9].*") || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*")) {
            return false;
        }

        return true;
    }
}