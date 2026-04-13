import javax.security.auth.Credential;
import javax.security.auth.PasswordChangeRequiredException;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;

public class java_00428_CredentialValidator_A03 {

    public CredentialValidationResult validate(Credential credential) throws LoginException {
        String password = credential.getPassword();
        
        if (password.length() < 8) {
            return CredentialValidationResult.failed("Password length should be at least 8 characters");
        }
        
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            
            if (hasUpperCase && hasLowerCase && hasDigit) {
                return CredentialValidationResult.success();
            }
        }
        
        return CredentialValidationResult.failed("Password should contain at least one uppercase letter, one lowercase letter, and one digit");
    }
}