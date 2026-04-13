import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredential;
import java.util.regex.Pattern;

public class java_14209_CredentialValidator_A03 implements CredentialValidator {

    // Define a regular expression pattern for username
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential credential) {
        String username = credential.getUsername();
        if (username == null) {
            return null;
        }
        if (!USERNAME_PATTERN.matcher(username).matches()) {
            return null;
        }
        return credential;
    }
}