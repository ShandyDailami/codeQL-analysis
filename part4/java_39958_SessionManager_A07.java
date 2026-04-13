import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Base64;

import javax.crypto.Cipher;

public class java_39958_SessionManager_A07 {

    private KeyStore keyStore;
    private Key encryptionKey;
    private Key decryptionKey;
    private PublicKey publicKey;
    private PrivateKey privateKey;

    public java_39958_SessionManager_A07() {
        // Load the keyStore and the encryption and decryption keys
        try {
            keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream("/keys.jks"), "password".toCharArray());

            // Assume keys are already in the keystore and are of the correct type
            // You may need to use a different method to get keys if you want
            Key key = keyStore.getKey("encryptionKeyAlias", "password".toCharArray());
            this.encryptionKey = key;

            key = keyStore.getKey("decryptionKeyAlias", "password".toCharArray());
            this.decryptionKey = key;

            Certificate cert = keyStore.getCertificate("publicKeyAlias");
            this.publicKey = (PublicKey) cert.getPublicKey();

            cert = keyStore.getCertificate("privateKeyAlias");
            this.privateKey = (PrivateKey) cert.getPrivateKey();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String encryptSessionData(String data) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, this.publicKey);

            byte[] encryptedData = cipher.doFinal(data.getBytes());

            return Base64.getEncoder().encodeToString(encryptedData);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String decryptSessionData(String encryptedData) {
        try {
            byte[] encryptedDataBytes = Base64.getDecoder().decode(encryptedData);

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, this.privateKey);

            byte[] decryptedDataBytes = cipher.doFinal(encryptedDataBytes);

            return new String(decryptedDataBytes);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}