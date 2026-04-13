import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordChangeRequiredException;
import javax.security.auth.login.CredentialException;

public class java_00322_CredentialValidator_A01 implements CredentialValidator {

    private String username;
    private String password;

    @Override
    public void validate(CredentialContext context) throws CredentialException, PasswordChangeRequiredException {
        username = context.getCallerPrincipal().getName();
        password = context.getPasswordAsString();
        
        if (!validatePassword(password)) {
            throw new CredentialException("Invalid password");
        }
    }

    private boolean validatePassword(String password) {
        // We're only using a simple check for a strong password
        // This is a basic check and may not cover all scenarios
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^\\w\\d\\s:])(?=.*[^\\s])[^\\s]$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    @Override
    public boolean getAcceptedDomainException() {
        // This method will not be called in this case
        return false;
    }

    public static void main(String[] args) {
        CustomValidator validator = new CustomValidator();
        // Use the validator here
    }
}