import java.util.regex.Pattern;

public class java_23989_CredentialValidator_A01 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String SPECIAL_CHARACTERS_REGEX = "[" + Pattern.quote(SPECIAL_CHARACTERS) + "]";
    private static final String NUMBER = "\\d";
    private static final String UPPERCASE = "\\p{Lu}";
    private static final String LOWERCASE = "\\p{Ll}";
    private static final String SINGLE_QUOTE = "['`]";
    private static final String PARENTHESES = "\\(.*?\\)";
    private static final String BLANKS = "\\s*";

    public boolean validatePassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            return false;
        }

        if (!Pattern.matches(NUMBER, password)) {
            return false;
        }

        if (!Pattern.matches(UPPERCASE, password)) {
            return false;
        }

        if (!Pattern.matches(LOWERCASE, password)) {
            return false;
        }

        if (!Pattern.matches(SPECIAL_CHARACTERS, password)) {
            return false;
        }

        return true;
    }
}