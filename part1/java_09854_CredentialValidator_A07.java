import javax.security.auth.Subject;
import javax.security.auth.password.PasswordValidator;
import javax.security.auth.password.PasswordEncoder;
import javax.security.auth.password.PasswordChangeAllowed;
import javax.security.auth.UsernamePasswordCredential;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class java_09854_CredentialValidator_A07 implements PasswordValidator, PasswordEncoder, PasswordChangeAllowed {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String password = credential.getPassword();
        return (hasUpperCase(password) && hasLowerCase(password) && hasDigit(password) && hasSpecialCharacter(password) && isAtLeast8Chars(password));
    }

    @Override
    public String encode(String password) {
        // We're not actually going to encode the password here, this is a mock-up
        return password;
    }

    @Override
    public boolean changePassword() {
        // We're not actually going to allow password changes here, this is a mock-up
        return false;
    }

    private boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private boolean hasDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    private boolean hasSpecialCharacter(String password) {
        return password.matches(".*[" + SPECIAL_CHARACTERS + "].*");
    }

    private boolean isAtLeast8Chars(String password) {
        return password.length() >= 8;
    }
}