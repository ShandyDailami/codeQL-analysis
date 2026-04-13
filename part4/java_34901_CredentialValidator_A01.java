import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.UsernamePasswordCredential;

public class java_34901_CredentialValidator_A01 implements CredentialValidator {

    // expected username and password
    private String expectedUsername = "admin";
    private String expectedPassword = "password";

    @Override
    public CredentialValidatorResult validate(UsernamePasswordCredential credential) {
        // if the provided username and password match the expected ones, return a successful result
        if (credential.getUsername().equals(expectedUsername) && credential.getPassword().equals(expectedPassword)) {
            return CredentialValidatorResult.success();
        } else {
            // if the provided credentials do not match the expected ones, return a failed result
            return CredentialValidatorResult.failed();
        }
    }
}