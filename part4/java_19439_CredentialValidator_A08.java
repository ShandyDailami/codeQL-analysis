import java.security.Credential;
import java.security.InvalidParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;

public class java_19439_CredentialValidator_A08 {

    private KeyStore keyStore;

    public java_19439_CredentialValidator_A08() throws NoSuchAlgorithmException, KeyStoreException {
        keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, null);
    }

    public boolean validateCredentials(String alias, String password, String certificatePassword) {
        try {
            Credential credential = keyStore.getKey(alias, password.toCharArray());

            if (credential instanceof PrivateKey) {
                PrivateKey privateKey = (PrivateKey) credential;
                return true;
            }

        } catch (UnrecoverableKeyException | NoSuchAlgorithmException | InvalidParameterException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}