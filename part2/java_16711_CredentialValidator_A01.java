import java.util.regex.Pattern;

public class java_16711_CredentialValidator_A01 {
    private static final String SPECIAL_CHARACTERS = "~`!@#$%^&*()=+[{\\|:;<,>.?/"'";
    private static final String SPECIAL_CHARACTERS_REGEX = Pattern.quote(SPECIAL_CHARACTERS);

    public static boolean isPasswordStrong(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = Pattern.matches(".*[A-Z].*", password);
        boolean hasLowerCase = Pattern.matches(".*[a-z].*", password);
        boolean hasNumber = Pattern.matches(".*[0-9].*", password);
        boolean hasSpecialCharacter = Pattern.matches(".*[" + SPECIAL_CHARACTERS_REGEX + "].*", password);

        return hasUpperCase && hasLowerCase && hasNumber && hasSpecialCharacter;
    }

    public static void main(String[] args) {
        System.out.println(isPasswordStrong("StrongPassword123!")); // Should print true
        System.out.println(isPasswordStrong("strongpassword123!")); // Should print false
        System.out.println(isPasswordStrong("strongpassword123")); // Should print false
        System.out.println(isPasswordStrong("StrongPassword123")); // Should print false
        System.out.println(isPasswordStrong("StrongPassw0rd!")); // Should print true
    }
}