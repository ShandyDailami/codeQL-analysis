import java.security.auth.Credential;
import java.security.auth.PasswordAuthentication;
import java.util.regex.Pattern;

public class java_07943_CredentialValidator_A08 implements CredentialValidator {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    @Override
    public PasswordAuthentication validate(Credential credential) {
        String password = credential.getPassword();
        if (PASSWORD_PATTERN.matcher(password).matches()) {
            return new PasswordAuthentication(password, null);
        } else {
            return null;
        }
    }
}