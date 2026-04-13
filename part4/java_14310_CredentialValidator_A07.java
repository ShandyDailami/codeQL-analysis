import java.util.regex.Pattern;

public class java_14310_CredentialValidator_A07 {

    private static final Pattern upperCaseLetter = Pattern.compile("[A-Z]");
    private static final Pattern lowerCaseLetter = Pattern.compile("[a-z]");
    private static final Pattern digit = Pattern.compile("[0-9]");
    private static final Pattern specialChar = Pattern.compile("[^a-zA-Z0-9]");

    public boolean validatePassword(String password) {
        return (hasUpperCaseLetter(password) && hasLowerCaseLetter(password) && hasDigit(password) && hasSpecialChar(password));
    }

    private boolean hasUpperCaseLetter(String password) {
        return upperCaseLetter.matcher(password).find();
    }

    private boolean hasLowerCaseLetter(String password) {
        return lowerCaseLetter.matcher(password).find();
    }

    private boolean hasDigit(String password) {
        return digit.matcher(password).find();
    }

    private boolean hasSpecialChar(String password) {
        return specialChar.matcher(password).find();
    }
}