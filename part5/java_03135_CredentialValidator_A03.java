import java.util.Arrays;

public class java_03135_CredentialValidator_A03 {

    private static final String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

    private static boolean containsSpecialCharacter(String password) {
        return password.matches(".*[~`!@#$%^&*()_+=\\-{}|\\[;\\]\"\\\\()<>?].*");
    }

    private static boolean containsLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private static boolean containsUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private static boolean containsNumber(String password) {
        return password.matches(".*[0-9].*");
    }

    private static boolean isValid(String password) {
        if (password.length() < 8) {
            return false;
        }

        if (!containsLowerCase(password)) {
            return false;
        }

        if (!containsUpperCase(password)) {
            return false;
        }

        if (!containsNumber(password)) {
            return false;
        }

        if (!containsSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] passwords = {"pass123", "Pass123!", "Pass1234567890", "Pass", "12345678", "Pass@12345678"};

        Arrays.stream(passwords).forEach(password -> {
            if (isValid(password)) {
                System.out.println("Password " + password + " is valid.");
            } else {
                System.out.println("Password " + password + " is not valid.");
            }
        });
    }
}