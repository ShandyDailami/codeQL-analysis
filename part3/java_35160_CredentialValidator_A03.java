import java.util.regex.Pattern;

public class java_35160_CredentialValidator_A03 {

    private static final Pattern UPPERCASE_LETTER = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE_LETTER = Pattern.compile("[a-z]");
    private static final Pattern DIGIT = Pattern.compile("[0-9]");
    private static final Pattern SPECIAL_CHARACTER = Pattern.compile("[^a-zA-Z0-9]");
    private static final Pattern ALL_CHARACTERS = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).+$");

    public boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            return false;
        }

        return (hasUpperCase(password) && hasLowerCase(password) && hasDigit(password) && hasSpecialCharacter(password));
    }

    private boolean hasUpperCase(String password) {
        return UPPERCASE_LETTER.matcher(password).find();
    }

    private boolean hasLowerCase(String password) {
        return LOWERCASE_LETTER.matcher(password).find();
    }

    private boolean hasDigit(String password) {
        return DIGIT.matcher(password).find();
    }

    private boolean hasSpecialCharacter(String password) {
        return SPECIAL_CHARACTER.matcher(password).find();
    }
}