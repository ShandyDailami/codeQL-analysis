import java.util.regex.Pattern;

public class java_23708_CredentialValidator_A07 implements CredentialValidator {
    private static final String SPECIAL_CHARACTERS = "~`·¨ˇ˘˛ÇæœΘπστρυφχψωqedbfntjzcvQWERTYUIOPASDFGHJKLZXCVBNM1234567890[]\\|@#!$%^&*()_+=";
    private static final String SPECIAL_CHARACTERS_REGEX = "[" + Pattern.quote(SPECIAL_CHARACTERS) + "]";

    @Override
    public boolean authenticate(String username, String password) {
        // Check for password strength
        boolean isWeak = password.length() < 8 || !password.matches(".*[a-z].*") || !password.matches(".*[A-Z].*") ||
                !password.matches(".*[0-9].*") || !password.matches(SPECIAL_CHARACTERS_REGEX);
        if (isWeak) {
            System.out.println("Password is weak. Please use a stronger password.");
            return false;
        }

        // Continue with authentication if password is strong
        // This is a placeholder and should not be used in production
        System.out.println("Authenticating user: " + username);
        return true;
    }
}