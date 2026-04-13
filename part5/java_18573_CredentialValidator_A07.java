import java.util.regex.Pattern;

public class java_18573_CredentialValidator_A07 {
    // Define the password requirements
    private static final Pattern uppercaseLetterPattern = Pattern.compile("[A-Z]");
    private static final Pattern lowercaseLetterPattern = Pattern.compile("[a-z]");
    private static final Pattern digitPattern = Pattern.compile("[0-9]");
    private static final Pattern specialCharacterPattern = Pattern.compile("[^a-zA-Z0-9]");

    public boolean validate(String password) {
        if (password.length() < 8) {
            return false;
        }

        if (!uppercaseLetterPattern.matcher(password).find()) {
            return false;
        }

        if (!lowercaseLetterPattern.matcher(password).find()) {
            return false;
        }

        if (!digitPattern.matcher(password).find()) {
            return false;
        }

        if (!specialCharacterPattern.matcher(password).find()) {
            return false;
        }

        return true;
    }
}