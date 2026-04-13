import java.util.regex.Pattern;

public class java_41981_CredentialValidator_A08 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!";

    @Override
    public boolean validate(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = Pattern.matches("[A-Z]", password);
        boolean hasLowerCase = Pattern.matches("[a-z]", password);
        boolean hasDigit = Pattern.matches("[0-9]", password);
        boolean hasSpecialChar = Pattern.matches("[" + SPECIAL_CHARACTERS + "]", password);

        return (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar);
    }
}