public class java_40939_CredentialValidator_A01 {
    // The minimum password length
    private static final int MIN_PASSWORD_LENGTH = 8;

    // The maximum password length
    private static final int MAX_PASSWORD_LENGTH = 16;

    // The minimum username length
    private static final int MIN_USERNAME_LENGTH = 4;

    // The maximum username length
    private static final int MAX_USERNAME_LENGTH = 20;

    public static boolean isValidUsername(String username) {
        return username != null && !username.trim().isEmpty() && username.length() >= MIN_USERNAME_LENGTH && username.length() <= MAX_USERNAME_LENGTH;
    }

    public static boolean isValidPassword(String password) {
        return password != null && !password.trim().isEmpty() && password.length() >= MIN_PASSWORD_LENGTH && password.length() <= MAX_PASSWORD_LENGTH;
    }

    public static boolean isValidCredentials(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }
}