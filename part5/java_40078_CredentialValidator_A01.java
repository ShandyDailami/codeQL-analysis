import javax.naming.AuthenticationToken;
import javax.naming.NameProvider;
import javax.naming.NamingException;

public class java_40078_CredentialValidator_A01 {
    private NameProvider provider;

    public java_40078_CredentialValidator_A01(NameProvider provider) {
        this.provider = provider;
    }

    public boolean validateCredentials(String user, String password) {
        try {
            AuthenticationToken token = new AuthenticationToken(user, password);
            provider.validate(token);
            return true;
        } catch (NamingException e) {
            e.printStackTrace();
            return false;
        }
    }
}