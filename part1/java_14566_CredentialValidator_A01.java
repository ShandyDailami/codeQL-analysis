import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.login.CredentialException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_14566_CredentialValidator_A01 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "~`!@#$%^&*()_+=-{}[]|\\:;<>,.?/";
    private static final Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9].*$).{8,}$");

    @Override
    public String validate(String arg0) throws CredentialException {
        Matcher matcher = pattern.matcher(arg0);
        if (!matcher.matches()) {
            throw new PasswordChangeException("Password does not meet the required criteria");
        }
        return null;
    }

    @Override
    public boolean validate(String arg0, String arg1) throws CredentialException {
        return validate(arg0) == null;
    }
}