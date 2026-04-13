import javax.security.auth.CredentialValidationResult;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_17727_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(javax.security.auth.Credential credential) throws LoginException {
        String password = credential.getCredential();

        // Check password length
        if (password.length() < 8) {
            return CredentialValidationResult.failed();
        }

        // Check for uppercase, lowercase, number, and special character
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!isValidSpecialChar(c)) {
                hasSpecialChar = true;
            }

            if (hasUpperCase && hasLowerCase && hasNumber && hasSpecialChar) {
                return CredentialValidationResult.success();
            }
        }

        return CredentialValidationResult.failed();
    }

    private boolean isValidSpecialChar(char c) {
        // you can define your own special characters here
        return !(c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']'
                || c == ';' || c == ':' || c == '<' || c == '>' || c == ',' || c == '.');
    }
}