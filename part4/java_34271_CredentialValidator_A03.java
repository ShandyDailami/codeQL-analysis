import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_34271_CredentialValidator_A03 implements CredentialValidator {

    private final static Pattern PASSWORD_PATTERN = Pattern.compile("password|P@ssw0rd|root|admin");

    @Override
    public String validate(String arg0) throws CredentialException {
        Matcher matcher = PASSWORD_PATTERN.matcher(arg0);
        if (!matcher.matches()) {
            throw new CredentialException("Invalid password");
        }
        return null;
    }
}