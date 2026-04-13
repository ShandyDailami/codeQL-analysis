import java.util.regex.Pattern;

public class java_15600_CredentialValidator_A03 {

    private static final Pattern upperCaseLetters = Pattern.compile("[A-Z]");
    private static final Pattern lowerCaseLetters = Pattern.compile("[a-z]");
    private static final Pattern numbers = Pattern.compile("[0-9]");
    private static final Pattern specialCharacters = Pattern.compile("[~!@#$%^&*()_=-\\\\+{}\":[]|\\\\?,.<>]");

    public boolean validate(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (!upperCaseLetters.matcher(password).find()) {
            return false;
        }
        if (!lowerCaseLetters.matcher(password).find()) {
            return false;
        }
        if (!numbers.matcher(password).find()) {
            return false;
        }
        if (!specialCharacters.matcher(password).find()) {
            return false;
        }
        return true;
    }
}