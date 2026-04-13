import java.util.regex.Pattern;

public class java_39623_CredentialValidator_A03 {

    public static void main(String[] args) {
        String password = "Password@123"; // Input your password here
        System.out.println(checkPasswordStrength(password));
    }

    // Function to check password strength
    public static String checkPasswordStrength(String password) {
        if (isPasswordTooShort(password)) return "Password is too short";
        if (isPasswordTooSimple(password)) return "Password is too simple";
        if (isPasswordTooLong(password)) return "Password is too long";
        if (isPasswordContainsWhitespace(password)) return "Password contains whitespace";
        if (isPasswordContainsSpecialCharacter(password)) return "Password contains special character";
        return "Password is strong";
    }

    // Functions to check password strength
    private static boolean isPasswordTooShort(String password) {
        return password.length() < 8;
    }

    private static boolean isPasswordTooSimple(String password) {
        return password.equals(password.toLowerCase()) || password.equals(password.toUpperCase()) || Pattern.matches("[0-9]+", password);
    }

    private static boolean isPasswordTooLong(String password) {
        return password.length() > 20;
    }

    private static boolean isPasswordContainsWhitespace(String password) {
        return password.contains(" ");
    }

    private static boolean isPasswordContainsSpecialCharacter(String password) {
        return !Pattern.matches("[a-zA-Z0-9]+", password);
    }
}