import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.PasswordChangeException;
import javax.security.auth.login.CredentialException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_11772_CredentialValidator_A03 implements CredentialValidator {

    private static final Pattern pattern;

    static {
        String s = new StringBuilder()
                .append("^(?=.*[0-9])")
                .append("^(?=.*[a-z])")
                .append("^(?=.*[A-Z])")
                .append("^(?=.*[@#$%^&+=])")
                .append("^(?=\\S+$)")
                .toString();
        pattern = Pattern.compile(s, Pattern.MULTILINE);
    }

    @Override
    public String validate(Object credentials) throws CredentialException {
        String password = (String) credentials;
        if (!passwordMatches(password)) {
            throw new InvalidCredentialException("Invalid password");
        }
        return null;
    }

    @Override
    public boolean validate(Object credentials, Object challenge) throws CredentialException, PasswordChangeException {
        return false;
    }

    private boolean passwordMatches(String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}