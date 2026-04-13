import java.util.Base64;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_22149_CredentialValidator_A01 {

    private static final Pattern VALID_USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9+/]+(\\.[A-Za-z0-9+/]+)*@[A-Za-z0-9]([A-Za-z0-9-]*[A-Za-z0-9])?(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    public boolean isValidUsername(String username) {
        Matcher matcher = VALID_USERNAME_PATTERN.matcher(username);
        return matcher.matches();
    }

    public boolean isValidPassword(String password) {
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public Optional<String> validate(String username, String password) {
        if (!isValidUsername(username)) {
            return Optional.of("Invalid username");
        }
        if (!isValidPassword(password)) {
            return Optional.of("Invalid password");
        }
        return Optional.empty();
    }

}