import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.Base64;
import javax.crypto.Cipher;

public class java_30145_CredentialValidator_A01 {

    public boolean validateCredentials(String credential, KeyStore keyStore, String alias, String password) throws Exception {
        KeyStoreInputStream ks = new KeyStoreInputStream(keyStore, password.toCharArray());
        KeyStore ks2 = KeyStore.getInstance("JKS");
        ks2.load(ks);
        Key key = ks2.getKey(alias, password.toCharArray());
        return key != null;
    }

    public String encryptAndSignCredentials(String credential, KeyStore keyStore, String alias, String password) throws Exception {
        KeyStoreInputStream ks = new KeyStoreInputStream(keyStore, password.toCharArray());
        KeyStore ks2 = KeyStore.getInstance("JKS");
        ks2.load(ks);
        Key key = ks2.getKey(alias, password.toCharArray());
        if (key == null) {
            throw new IllegalArgumentException("Invalid alias/password");
        }
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedCredential = cipher.doFinal(credential.getBytes());
        return Base64.getEncoder().encodeToString(encryptedCredential);
    }
}