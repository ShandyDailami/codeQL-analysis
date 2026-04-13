import java.security.Credential;
import java.security.GeneralSecurityException;

public class java_38352_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public String getHow() {
        return "Custom Credential Validator";
    }

    @Override
    public String getRequiredType() {
        return Credential.PASSWORD_TYPE;
    }

    @Override
    public boolean validate(Credential credential) throws GeneralSecurityException {
        String password = credential.getPasswordData().toString();
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasLowerCase = password.matches(".*[a-z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecialChar = password.matches(".*[^a-zA-Z0-9].*");
        
        return hasUpperCase && hasLowerCase && hasNumber && hasSpecialChar;
    }

}