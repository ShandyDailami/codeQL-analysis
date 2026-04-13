import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.InvalidCredentialException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_38509_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(javax.security.auth.Credential credential) {
        String password = credential.getCredentialIdentifier();
        if (password.length() < 8) {
            return CredentialValidationResult.failed();
        }
        Pattern pattern = Pattern.compile("[A-Z]+.*", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            return CredentialValidationResult.failed();
        }
        pattern = Pattern.compile("[a-z]+.*", Pattern.MULTILINE);
        matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            return CredentialValidationResult.failed();
        }
        pattern = Pattern.compile("[0-9]+.*", Pattern.MULTILINE);
        matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            return CredentialValidationResult.failed();
        }
        return CredentialValidationResult.success();
    }
}