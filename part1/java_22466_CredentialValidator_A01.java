public class java_22466_CredentialValidator_A01 {
    private static final List<String> WEAK_PASSWORD_PATTERNS = Arrays.asList(
            "12345", "password", "admin", "qwerty", "admin123", "111111", "123456", "123abc",
            "12345abc", "abc12345", "12abc345", "1a2b3c4d", "12345abcdef", "123abcdefg", "abcdefg",
            "12345abcde", "abcdef1234", "abc12345abc", "abcdef12345", "abc12345abc6", "abc123abc",
            "abc123abcdef", "abc123abcdefg", "abcdefgh", "abcdefghi", "abcdefghij", "abcdefghijs",
            "abcdefghijkl", "abcdefghijklmn", "abcdefghijklmno", "abcdefghijklmnop", "abcdefghijklmnopq",
            "abcdefghijklmnopqr", "abcdefghijklmnopqrs", "abcdefghijklmnopqrst", "abcdefghijklmnopqrstu",
            "abcdefghijklmnopqrstuv", "abcdefghijklmnopqrstuvw", "abcdefghijklmnopqrstuvwx", "abcdefghijklmnopqrstuvwxy");

    public static boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("password cannot be null");
        }
        if (password.length() < 8) {
            return false;
        }
        if (WEAK_PASSWORD_PATTERNS.contains(password)) {
            return false;
        }
        if (!hasUpperCase(password)) {
            return false;
        }
        if (!hasLowerCase(password)) {
            return false;
        }
        if (!hasDigit(password)) {
            return false;
        }
        if (!hasSpecialCharacter(password)) {
            return false;
        }
        return true;
    }

    private static boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private static boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private static boolean hasDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    private static boolean hasSpecialCharacter(String password) {
        return password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
}