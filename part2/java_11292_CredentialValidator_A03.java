import java.security.Principal;
import java.security.credential.Credential;
import java.security.credential.CredentialNotFoundException;
import java.security.credential.CredentialProvider;
import java.security.credential.CredentialProviderNotFoundException;
import java.security.PrincipalNotFoundException;

public class java_11292_CredentialValidator_A03 implements CredentialProvider {

    private String[] usernames = {"user1", "user2", "user3"};
    private String[] passwords = {"password1", "password2", "password3"};
    private int currentIndex = 0;

    @Override
    public Credential validatedCredential(Principal principal, String credentials) throws CredentialNotFoundException {
        return new CustomCredential(principal, credentials);
    }

    @Override
    public Credential findCredential(Class<? extends Credential> type) throws CredentialProviderNotFoundException {
        return null;
    }

    private class CustomCredential implements Credential {
        private Principal principal;
        private String credentials;

        public java_11292_CredentialValidator_A03(Principal principal, String credentials) {
            this.principal = principal;
            this.credentials = credentials;
        }

        @Override
        public String getCredential() {
            return credentials;
        }

        @Override
        public Principal getPrincipal() throws PrincipalNotFoundException {
            return principal;
        }
    }
}