import java.security.Principal;

public class java_29159_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator {

    @Override
    public Principal validate(javax.security.auth.credential.Credential credential) {
        String userName = credential.getCredentialIdentifier();
        if ("admin".equals(userName)) {
            String password = new String(credential.getCredentials());
            if ("password".equals(password)) {
                return new Principal(userName);
            }
        }
        return null;
    }
}