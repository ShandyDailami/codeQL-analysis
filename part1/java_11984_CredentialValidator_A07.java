import javax.security.auth.Credential;
import javax.security.auth.login.LoginException;

public class java_11984_CredentialValidator_A07 implements Credential {

    private String userName;
    private String password;

    public java_11984_CredentialValidator_A07(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String getCredential(String s) throws LoginException {
        return password;
    }

    @Override
    public boolean validate(Credential credential) throws LoginException {
        if (credential instanceof AuthFailureExample) {
            AuthFailureExample other = (AuthFailureExample) credential;
            return userName.equals(other.userName) && password.equals(other.password);
        } else {
            throw new LoginException("Invalid credential type");
        }
    }
}