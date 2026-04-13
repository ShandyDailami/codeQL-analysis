import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_06651_CredentialValidator_A03 implements CredentialValidator {

    private static final Pattern BASIC_AUTH_PATTERN = Pattern.compile("Basic ([A-Za-z0-9+/]+)");

    @Override
    public boolean validate(String username, String password) {
        // Convert the plain text password to base64.
        String base64Password = Base64.getEncoder().encodeToString(password.getBytes());

        // Extract the basic auth header from the request.
        Matcher matcher = BASIC_AUTH_PATTERN.matcher(username);
        if (!matcher.matches()) {
            throw new InvalidUsernameException("Invalid username format: " + username);
        }
        String base64Credentials = matcher.group(1);

        // Decode the base64 credentials and compare with the original password.
        String decodedCredentials = new String(Base64.getDecoder().decode(base64Credentials), StandardCharsets.UTF_8);
        return decodedCredentials.equals(password);
    }
}