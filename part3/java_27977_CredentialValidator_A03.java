import java.security.Credentials;
import java.security.GeneralSecurityException;

public class java_27977_CredentialValidator_A03 implements CredentialsValidator {

    private String username;
    private String password;

    public java_27977_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean validate(Credentials credentials) {
        try {
            String presentedPassword = credentials.getPassword().toString();

            // Check if presented password matches expected password
            if (presentedPassword.equals(this.password)) {
                return true;
            }
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return false;
    }

}