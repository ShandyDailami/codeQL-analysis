import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.AuthContext;
import java.security.Security;

public class java_14667_CredentialValidator_A01 implements CredentialValidator {

    private String username;
    private String password;

    public java_14667_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public CredentialValidationResult validate(Credential credential) throws LoginException {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential upCredential = (UsernamePasswordCredential) credential;

            if (upCredential.getCaller().equals(username) && upCredential.getPassword().equals(password)) {
                return CredentialValidationResult.VALID;
            }
        }
        return CredentialValidationResult.INVALID;
    }
}