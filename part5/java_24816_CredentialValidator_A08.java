import javax.security.auth.Subject;
import javax.security.auth.password.CredentialValidator;
import javax.security.auth.password.PasswordChangeException;
import javax.security.auth.password.PasswordValidator;
import javax.security.auth.CredentialException;

public class java_24816_CredentialValidator_A08 implements PasswordValidator, CredentialValidator {

    private static final String SPECIAL_CHARACTER_PATTERN = "[a-zA-Z0-9]*";
    private static final String NUMBER_PATTERN = "\\d+";

    @Override
    public String validate(String arg0) throws CredentialException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean validate(Credential credential) throws CredentialException {
        String password = credential.getCredentialIdentifier();

        if (password == null) {
            throw new CredentialException("Password cannot be null");
        }

        if (!password.matches(SPECIAL_CHARACTER_PATTERN + NUMBER_PATTERN)) {
            throw new CredentialException("Password must contain at least one number and one special character");
        }

        return true;
    }

    @Override
    public Subject validate(Subject subject, String password) throws CredentialException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void modifyCredentials(String arg0) throws CredentialException {
        // TODO Auto-generated method stub
    }

    @Override
    public String getPasswordResetQuestion() throws CredentialException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPasswordResetKey() throws CredentialException {
        // TODO Auto-generated method stub
        return null;
   
    }
}