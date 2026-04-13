import java.util.regex.Pattern;

public class java_30424_CredentialValidator_A08 implements CredentialValidator {
    private static final Pattern SPECIAL_CHARACTER_PATTERN = Pattern.compile("[^a-zA-Z0-9]");
    private static final Pattern UPPERCASE_LOWERCASE_NUMBER_PATTERN = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])");

    @Override
    public boolean validate(String password) {
        return password.length() >= 8 && // at least 8 characters
                SPECIAL_CHARACTER_PATTERN.matcher(password).find() && // contains special character
                UPPERCASE_LOWERCASE_NUMBER_PATTERN.matcher(password).find(); // contains uppercase and lowercase letters and numbers
    }
}