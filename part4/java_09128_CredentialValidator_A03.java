import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_09128_CredentialValidator_A03 {

    private static final Pattern AUTH_PATTERN = Pattern.compile("Basic (.*?)");

    public boolean validate(String headerValue) {
        Matcher matcher = AUTH_PATTERN.matcher(headerValue);
        if (matcher.matches()) {
            String base64Credentials = matcher.group(1);
            String credentials = new String(Base64.getDecoder().decode(base64Credentials), "UTF-8");
            String[] splitCredentials = credentials.split(":", 2);
            if (splitCredentials.length == 2) {
                String username = splitCredentials[0];
                String password = splitCredentials[1];
                // Here you would place the code to validate the username and password against your database or security system.
                // For now, we'll just check if the username is "admin" and the password is "password".
                return username.equals("admin") && password.equals("password");
            }
        }
        return false;
    }
}