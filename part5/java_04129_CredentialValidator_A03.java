import java.util.regex.Pattern;

public class java_04129_CredentialValidator_A03 {
    private static final Pattern lowerCase = Pattern.compile("[a-z]");
    private static final Pattern upperCase = Pattern.compile("[A-Z]");
    private static final Pattern digit = Pattern.compile("[0-9]");
    private static final Pattern specialChar = Pattern.compile("[^a-zA-Z0-9]");

    public boolean validate(String password) {
        if (password == null || password.length() < 6) {
            return false;
        }

        if (!lowerCase.matcher(password).find()) {
            return false;
        }

        if (!upperCase.matcher(password).find()) {
            return false;
        }

        if (!digit.matcher(password).find()) {
            return false;
        }

        if (!specialChar.matcher(password).find()) {
            return false;
        }

        return true;
    }
}