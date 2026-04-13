import javax.management.AuthenticationException;
import java.util.Base64;

public class java_17347_CredentialValidator_A08 implements CredentialValidator {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    @Override
    public CredentialValidationResult validate(Credential c) throws AuthenticationException {
        String presentedPassword = new String(Base64.getDecoder().decode(c.getCredentials()));
        if (USERNAME.equals(c.getIdentity()) && PASSWORD.equals(presentedPassword)) {
            return new CredentialValidationResult("Success", null);
        } else {
            return new CredentialValidationResult("Failure", null);
        }
    }
}