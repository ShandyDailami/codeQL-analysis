import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;
import java.util.regex.Pattern;

public class java_37433_CredentialValidator_A08 implements CredentialValidator {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%^*?&])[A-Za-z0-9@$!%^*?&]{8,}$");

    @Override
    public String validate(String argument) throws CredentialException {
        if (!PASSWORD_PATTERN.matcher(argument).matches()) {
            throw new InvalidCredentialException("Password does not match the required pattern");
        }
        return null;
    }

    @Override
    public boolean getSupported(Class<?> authentication) {
        return true;
    }
}