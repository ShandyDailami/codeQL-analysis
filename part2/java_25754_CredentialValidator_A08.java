import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialInvalidException;
import javax.security.auth.login.LoginException;
import javax.security.auth.Subject;
import java.util.regex.Pattern;

public class java_25754_CredentialValidator_A08 implements CredentialValidator {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    @Override
    public String validate(CredentialContext credentialContext) throws CredentialInvalidException {
        Subject subject = credentialContext.getCallerSubject();
        String password = subject.getPrincipal().toString();

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new CredentialInvalidException("Invalid password");
        }

        return null;
    }
}