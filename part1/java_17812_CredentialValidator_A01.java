public class java_17812_CredentialValidator_A01 {

    // Minimum password length
    private static final int MIN_PASSWORD_LENGTH = 8;

    // Maximum password length
    private static final int MAX_PASSWORD_LENGTH = 16;

    // Check for specific sequence of characters in password
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+=-[]{};':\",.<>?`~";

    // Check for specific sequences in password
    private static final String SPECIAL_SEQUENCES = "1234567890";

    // Check for specific sequences in password
    private static final String UPPERCASE_LOWERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    // Check for specific sequences in password
    private static final String NUMBERS = "0123456789";

    // Minimum length of password
    private static final int MIN_PASSWORD_LENGTH_SPECIAL_CHARACTERS = 2;

    // Maximum length of password
    private static final int MAX_PASSWORD_LENGTH_SPECIAL_CHARACTERS = 3;

    // Validate password
    public static boolean isPasswordValid(String password) {
        if (password == null || password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        if (password.length() > MAX_PASSWORD_LENGTH) {
            return false;
        }

        if (password.matches(".*[" + SPECIAL_CHARACTERS + "].*") == false) {
            return false;
        }

        if (password.matches(".*[" + NUMBERS + "].*") == false) {
            return false;
        }

        if (password.matches(".*[" + UPPERCASE_LOWERCASE + "].*") == false) {
            return false;
        }

        if (password.matches(".*[" + SPECIAL_SEQUENCES + "].*") == false) {
            return false;
        }

        return true;
    }

    // Test
    public static void main(String[] args) {
        System.out.println(isPasswordValid("Passw0rd!"));
        System.out.println(isPasswordValid("Passw0rd!123"));
        System.out.println(isPasswordValid("Passw0rd123"));
        System.out.println(isPasswordValid("Passw0rd1234"));
        System.out.println(isPasswordValid("Passw0rd!1234"));
    }
}