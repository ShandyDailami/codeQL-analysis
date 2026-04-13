import java.util.regex.Pattern;

public class java_33613_CredentialValidator_A03 implements CredentialValidator {

    private static final Pattern UPPERCASE_LETTER = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE_LETTER = Pattern.compile("[a-z]");
    private static final Pattern NUMBER = Pattern.compile("[0-9]");
    private static final Pattern SPECIAL_CHARACTER = Pattern.compile("[^a-zA-Z0-9]");
    private static final Pattern MIN_EIGHT_CHARACTERS = Pattern.compile(".{8,}");

    @Override
    public boolean validate(String username, String password) {
        if (!MIN_EIGHT_CHARACTERS.matcher(password).matches()) {
            return false;
        }
        if (!UPPERCASE_LETTER.matcher(password).matches()) {
            return false;
        }
        if (!LOWERCASE_LETTER.matcher(password).matches()) {
            return false;
        }
        if (!NUMBER.matcher(password).matches()) {
            return false;
        }
        if (!SPECIAL_CHARACTER.matcher(password).matches()) {
            return false;
        }
        return true;
    }
}