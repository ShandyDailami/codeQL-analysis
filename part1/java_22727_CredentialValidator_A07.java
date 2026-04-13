import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.InvalidCredentialException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_22727_CredentialValidator_A07 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_+=-[{]}|\\:;\"<>,.?/";
    private static final Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^4-9a-km-zA-HJ-NP-Z-np-za-hj-km-z]).{8,}$");

    @Override
    public CredentialValidatorResult validate(Credential credential) throws InvalidCredentialException {
        String password = credential.getPassword();

        if (password == null) {
            throw new InvalidCredentialException("Password cannot be null");
        } else if (password.length() < 8) {
            throw new InvalidCredentialException("Password must be at least 8 characters long");
        } else if (!containsSpecialCharacter(password)) {
            throw new InvalidCredentialException("Password must contain at least one special character");
        }

        return new CredentialValidatorResult.Success("Credentials Validated Successfully");
    }

    private boolean containsSpecialCharacter(String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}