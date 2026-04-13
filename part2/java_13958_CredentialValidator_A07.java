import java.util.regex.Pattern;

public class java_13958_CredentialValidator_A07 {

    private static final String SPECIAL_CHARACTERS = "~!@#%^&*()_+`={}|[]\\\\:;<'>,?/";
    private static final String NUMBERS = "0123456789";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public boolean isPasswordStrong(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            return false;
        }

        if (!hasNumber(password)) {
            return false;
        }

        if (!hasUppercaseLetter(password)) {
            return false;
        }

        if (!hasLowercaseLetter(password)) {
            return false;
        }

        if (!hasSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    private boolean hasNumber(String password) {
        return password.regionMatches(true, 0, NUMBERS, 0, password.length());
    }

    private boolean hasUppercaseLetter(String password) {
        return password.regionMatches(true, 0, UPPERCASE_LETTERS, 0, password.length());
    }

    private boolean hasLowercaseLetter(String password) {
        return password.regionMatches(true, 0, LOWERCASE_LETTERS, 0, password.length());
    }

    private boolean hasSpecialCharacter(String password) {
        return password.regionMatches(true, 0, SPECIAL_CHARACTERS, 0, password.length());
    }
}