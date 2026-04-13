import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;

import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialNotFoundException;
import javax.security.auth.credential.CredentialProvider;
import javax.security.auth.credential.CredentialProviderBrokenInterface;

public class java_13891_CredentialValidator_A01 implements CredentialProvider, CredentialProviderBrokenInterface {

    private static final String USER_DB = "myUserDB";
    private static final String PASSWORD_DB = "myPasswordDB";

    @Override
    public Credential validate(Credential credential) throws CredentialNotFoundException {
        String user = credential.getIdentifier();
        String password = new String(credential.getCredential());

        if (user.equals(USER_DB) && password.equals(PASSWORD_DB)) {
            return new MyCredential(user, password);
        } else {
            throw new CredentialNotFoundException("Invalid username or password");
        }
    }

    @Override
    public boolean broken(String s) throws NoSuchAlgorithmException, InvalidKeySpec {
        return false;
    }

    private static class MyCredential implements Credential {
        private final String identity;
        private final char[] credentials;

        public java_13891_CredentialValidator_A01(String identity, String password) {
            this.identity = identity;
            this.credentials = password.toCharArray();
        }

        @Override
        public String getIdentifier() {
            return identity;
        }

        @Override
        public String getCredential() {
            return new String(credentials);
        }
    }
}