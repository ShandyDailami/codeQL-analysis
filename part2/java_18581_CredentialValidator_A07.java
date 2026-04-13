import java.security.Security;
import java.util.regex.Pattern;

public class java_18581_CredentialValidator_A07 {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])");

    public static boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        Security.setProperty("sun.security.ssl.allowAllHosts", "true");
        Security.addProvider(new org.apache.commons.jci.ConnectorProvider());

        CredentialValidator validator = new CredentialValidator() {
            public boolean validate(String credentials) {
                return isPasswordStrong(credentials);
            }
        };

        // Usage of validator
    }
}