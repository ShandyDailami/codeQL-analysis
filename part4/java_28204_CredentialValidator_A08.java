import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_28204_CredentialValidator_A08 implements LoginModule {

    private String username;
    private char[] password;

    @Override
    public void initialize(String name, Map<String, ?> properties) {
        this.username = name;
        this.password = properties.get("password").toString().toCharArray();
    }

    @Override
    public Credential authenticate(Credential arg0) {
        if(this.username.equals(arg0.getIdentifier()) && this.password.equals(arg0.getCredential())) {
            return new UsernamePasswordCredential(arg0.getIdentifier(), arg0.getCredential());
        } else {
            return null;
        }
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    @Override
    public void cleanup() {
        //nothing to cleanup
    }
}