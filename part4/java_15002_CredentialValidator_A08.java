import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.Base64;
import javax.crypto.Cipher;

public class java_15002_CredentialValidator_A08 {
    private KeyStore keystore;

    public java_15002_CredentialValidator_A08() throws Exception {
        keystore = KeyStore.getInstance("JKS");
        keystore.load(getClass().getResourceAsStream("/credentials.jks"), "password".toCharArray());
    }

    public String decryptCredential(String encryptedCredential) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, getPrivateKeyFromKeystore(keystore));
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedCredential)), "UTF-8");
    }

    private PrivateKey getPrivateKeyFromKeystore(KeyStore keystore) throws Exception {
        Key key = keystore.getKey("privateKeyAlias", "password".toCharArray());
        if (key instanceof PrivateKey) {
            return (PrivateKey) key;
        }
        throw new Exception("Key not found or not the right type");
    }
}