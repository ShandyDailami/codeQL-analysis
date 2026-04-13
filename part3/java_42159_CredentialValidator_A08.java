import java.security.Credential;
import java.security.AccessControlException;

public class java_42159_CredentialValidator_A08 implements CredentialValidator {

    private String requiredPassword;

    public java_42159_CredentialValidator_A08(String requiredPassword) {
        this.requiredPassword = requiredPassword;
    }

    @Override
    public boolean validate(Credential credential) {
        try {
            String userPassword = credential.getPassword();
            return userPassword.equals(requiredPassword);
        } catch (AccessControlException e) {
            e.printStackTrace();
            return false;
        }
    }
}