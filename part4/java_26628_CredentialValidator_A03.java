import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_26628_CredentialValidator_A03 {

    private static final String SPECIAL_CHARACTERS = "~`!@#$%^&*()_+={}[]|\\:;\"'<,>.?/";

    public static boolean isStrongPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        boolean hasDigit = Pattern.matches(".*[0-9].*", password);
        boolean hasLowerCase = Pattern.matches(".*[a-z].*", password);
        boolean hasUpperCase = Pattern.matches(".*[A-Z].*", password);
        boolean hasSpecialCharacter = Pattern.matches(".*[" + SPECIAL_CHARACTERS + "].*", password);

        return hasDigit && hasLowerCase && hasUpperCase && hasSpecialCharacter;
    }

    public static void main(String[] args) {
        System.out.println(isStrongPassword("Password123!")); // Outputs: true
        System.out.println(isStrongPassword("password")); // Outputs: false
    }
}