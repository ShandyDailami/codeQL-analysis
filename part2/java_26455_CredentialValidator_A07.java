import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import javax.crypto.Cipher;

public class java_26455_CredentialValidator_A07 {

    private KeyStore keyStore;

    public java_26455_CredentialValidator_A07() {
        try {
            this.keyStore = KeyStore.getInstance("JKS");
            this.keyStore.load(getClass().getResourceAsStream("/keystore.jks"), "password".toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String decryptData(String encryptedData) {
        String decryptedData = null;
        try {
            Key key = this.keyStore.getKey("alias", "password".toCharArray());
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            decryptedData = new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedData;
    }
}