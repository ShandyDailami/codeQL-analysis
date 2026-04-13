import javax.security.auth.CredentialValidationResult;
import javax.security.auth.PasswordValidator;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_30307_CredentialValidator_A08 implements PasswordValidator {

    @Override
    public CredentialValidationResult validate(javax.security.auth.Credential credential) {
        String password = credential.getPassword();
        
        if (password.length() < 8) {
            return CredentialValidationResult.failed("Password must be at least 8 characters long");
        }
        
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
            
            if (hasUpperCase && hasLowerCase && hasDigit) {
                return CredentialValidationResult.versioned(CredentialValidationResult.OK_RESULT);
            }
        }
        
        return CredentialValidationResult.failed("Password must contain at least one uppercase letter, one lowercase letter, and one digit");
    }
    
}