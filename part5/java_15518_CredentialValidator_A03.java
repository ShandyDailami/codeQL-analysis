import java.util.Base64;
import java.util.Base64.Decoder;

import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_15518_CredentialValidator_A03 implements LoginModule {

    private String user = "user";
    private String password = "password";

    @Override
    public Credential authenticate(Credential credential) throws LoginException {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential upCredential = (UsernamePasswordCredential) credential;

            String presentedPassword = upCredential.getPassword();
            Decoder decoder = Base64.getDecoder();
            String decodedPassword = new String(decoder.decode(presentedPassword));

            if (user.equals(upCredential.getIdentifier()) && password.equals(decodedPassword)) {
                return new UsernamePasswordCredential(user, decodedPassword);
            }
        }
        return null;
    }

    @Override
    public void validate(Credential c) throws LoginException {
        // No need to implement the validate method in this case
    }
}