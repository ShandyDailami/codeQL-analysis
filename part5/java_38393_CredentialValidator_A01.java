import java.util.regex.Pattern;

public class java_38393_CredentialValidator_A01 {
    private static final Pattern UPPERCASE_LETTER = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE_LETTER = Pattern.compile("[a-z]");
    private static final Pattern NUMBER = Pattern.compile("[0-9]");
    private static final Pattern SPECIAL_CHARACTER = Pattern.compile("[^a-zA-Z0-9]");
    private static final Pattern MIN_LENGTH = Pattern.compile("^.{8,}$");

    public boolean validate(String password) {
        if (!MIN_LENGTH.matcher(password).matches()) {
            return false;
        }

        if (password.equals(password.toLowerCase())
                || password.equals(password.toUpperCase())
                || password.equals(password.replaceAll("[0-9]", ""))
                || password.equals(password.replaceAll("[^a-zA-Z]", ""))) {
            return false;
        }

        return UPPERCASE_LETTER.matcher(password).find()
                && LOWERCASE_LETTER.matcher(password).find()
                && NUMBER.matcher(password).find()
                && SPECIAL_CHARACTER.matcher(password).find();
    }
}