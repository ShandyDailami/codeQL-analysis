import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.DefaultLoginModule;

public class java_18719_CredentialValidator_A07 extends DefaultLoginModule {

    @Override
    public CredentialValidationResult validate(javax.security.auth.Credential credential) throws LoginException {
        String username = credential.getCaller();
        String password = credential.getPassword();

        if (username == null || password == null) {
            return CredentialValidationResult.failed();
        }

        if (!hasDigit(password) || !hasUpperCase(password) || !hasLowerCase(password) || !hasSpecialCharacter(password)) {
            return CredentialValidationResult.failed();
        }

        return CredentialValidationResult.success();
    }

    private boolean hasDigit(String s) {
        return s.matches(".*[0-9].*");
    }

    private boolean hasUpperCase(String s) {
        return s.matches(".*[A-Z].*");
    }

    private boolean hasLowerCase(String s) {
        return s.matches(".*[a-z].*");
    }

    private boolean hasSpecialCharacter(String s) {
        return s.matches(".*[!@#$%^&*()_+\\-={}|\\[\\]\\\\;:<>,.?].*");
    }
}