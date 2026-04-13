import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class java_23370_CredentialValidator_A01 {
    // Assume the KeyStore and Key are secure and accessible
    private KeyStore keyStore;
    private Key key;

    public java_23370_CredentialValidator_A01() throws KeyStoreException, CertificateException, NoSuchAlgorithmException {
        this.keyStore = KeyStore.getInstance("JKS");
        this.keyStore.load(getClass().getResourceAsStream("/path_to_your_keystore.jks"), "password".toCharArray());
        this.key = this.keyStore.getKey("alias", "password".toCharArray());
    }

    public boolean validate(String alias, String password) {
        try {
            Key key = this.keyStore.getKey(alias, password.toCharArray());
            if (key != null) {
                return true;
            } else {
                return false;
            }
        } catch (KeyStoreException | UnsupportedOperationException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            new CredentialValidator().validate("alias", "password");
            System.out.println("Access granted!");
        } catch (Exception e) {
            System.out.println("Access denied!");
        }
    }
}