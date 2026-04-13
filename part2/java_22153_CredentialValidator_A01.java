import java.util.regex.Pattern;

public class java_22153_CredentialValidator_A01 {

    private static final Pattern UPPERCASE_LETTER = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE_LETTER = Pattern.compile("[a-z]");
    private static final Pattern SPECIAL_CHARACTER = Pattern.compile("[^a-zA-Z0-9]");

    public boolean isValidPassword(String password) {
        return (UPPERCASE_LETTER.matcher(password).find()) &&
                (LOWERCASE_LETTER.matcher(password).find()) &&
                (SPECIAL_CHARACTER.matcher(password).find());
    }
}