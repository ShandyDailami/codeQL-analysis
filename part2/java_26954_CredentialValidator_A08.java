import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class java_26954_CredentialValidator_A08 implements CredentialValidator {

    private static final String KEYSTORE_PATH = "/path/to/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String KEY_ALIAS = "alias";

    @Override
    public Key getKey(String keyAlgorithm) throws NoSuchAlgorithmException {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream(KEYSTORE_PATH), KEYSTORE_PASSWORD.toCharArray());
            return keyStore.getKey(KEY_ALIAS, new char[]{});
        } catch (IOException | UnavailableException | NoSuchAlgorithmException | KeyStoreException | CertificateException e) {
            throw new InvalidParameterException("Failed to load key from keystore", e);
        }
    }

    @Override
    public String getPassword() {
        return KEYSTORE_PASSWORD;
    }

    @Override
    public String getUserName() {
        return KEY_ALIAS;
    }

    @Override
    public void validate(String inputPassword) throws AuthenticationFailed {
        try {
            if (getKey("RSA").toString().equals(inputPassword)) {
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new AuthenticationFailed("Invalid password");
    }
}