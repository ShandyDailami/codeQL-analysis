import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.CallerPrincipalCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.CredentialException;

public class java_02546_CredentialValidator_A03 implements javax.security.auth.CredentialValidator {

    @Override
    public CredentialValidationResult validate(CallerPrincipalCallback caller, PasswordCallback password) throws CredentialException {
        String passwordValue = password.getPassword();

        // Define the pattern to match
        String pattern = "^[a-zA-Z0-9]{8,}$";

        // Check if the password matches the pattern
        if (passwordValue.matches(pattern)) {
            // Password is valid, return a successful result
            return CredentialValidationResult.success();
        } else {
            // Password is not valid, return a failed result
            return CredentialValidationResult.failed();
        }
    }

}