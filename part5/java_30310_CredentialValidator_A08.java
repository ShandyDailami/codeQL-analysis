import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class java_30310_CredentialValidator_A08 {

    private KeyStore keyStore;
    private Key key;
    private Cipher cipher;

    public java_30310_CredentialValidator_A08() {
        try {
            keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream("/keystore.jks"), "password".toCharArray());
            key = keyStore.getKey("keyalias", "password".toCharArray());
            cipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException | UnrecoverableKeyException | KeyStoreException | NoSuchPaddingException | CertificateException e) {
            e.printStackTrace();
        }
    }

    public boolean validate(String password) {
        try {
            Certificate certificate = keyStore.getCertificate("keyalias");
            cipher.init(Cipher.DECRYPT_MODE, certificate, key);
            byte[] decryptedPassword = cipher.doFinal(password.getBytes());
            return new String(decryptedPassword).equals("password");
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            return false;
        }
    }

}