import javax.security.auth.Subject;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;
import javax.security.auth.x500.X500Principal;
import java.security.Principal;

public class java_22857_CredentialValidator_A08 {

    public static class CustomCredential implements java.security.credential.Credential {

        private final String realm;

        public java_22857_CredentialValidator_A08(String realm) {
            this.realm = realm;
        }

        @Override
        public String getRealm() {
            return realm;
        }

        @Override
        public Principal getPrincipal() throws CredentialNotFoundException {
            return new X500Principal("CN=" + realm);
        }

        @Override
        public boolean authenticate(String userName, String password) throws LoginException {
            // TODO: implement authentication logic
            return false;
        }
    }

    public CustomCredential createCredential(String realm) throws LoginException {
        return new CustomCredential(realm);
    }

    public boolean validate(Subject subject, CustomCredential credential) throws LoginException {
        if (credential.authenticate(credential.getRealm(), credential.getRealm())) {
            subject.getPrincipals().add(credential.getPrincipal());
            return true;
        } else {
            throw new LoginException("Authentication failed.");
        }
    }
}