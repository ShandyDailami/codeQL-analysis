import org.mindrot.jbcrypt.BCrypt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface CredentialValidator {
    boolean isValidPassword(String password);
}

public class java_29916_CredentialValidator_A01 implements CredentialValidator {

    private static final Pattern VALID_PASSWORD_PATTERN =
        Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$)");

    @Override
    public boolean isValidPassword(String password) {
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(password);
        if (!matcher.matches()) {
            return false;
        }

        return BCrypt.checkpw(password, BCrypt.gensalt());
    }
}