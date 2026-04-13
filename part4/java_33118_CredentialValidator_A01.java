import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_33118_CredentialValidator_A01 {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9]{8,}$");

    public boolean validate(String username, String password) {
        Matcher usernameMatcher = USERNAME_PATTERN.matcher(username);
        Matcher passwordMatcher = PASSWORD_PATTERN.matcher(password);

        return usernameMatcher.matches() && passwordMatcher.matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "validUser";
        String password = "validPassword";

        if (validator.validate(username, password)) {
            System.out.println("Credentials are valid!");
        } else {
            System.out.println("Credentials are invalid!");
        }
    }
}