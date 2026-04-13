import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.Base64;
import javax.crypto.Cipher;

public class java_01277_CredentialValidator_A03 {
    private final KeyStore keystore;

    public java_01277_CredentialValidator_A03(KeyStore keystore) {
        this.keystore = keystore;
    }

    public String encryptPassword(String password) throws Exception {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        Key key = getKeyFromKeystore();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encryptedPassword = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encryptedPassword);
    }

    public String decryptPassword(String encryptedPassword) throws Exception {
        if (encryptedPassword == null) {
            throw new IllegalArgumentException("Encrypted password cannot be null");
        }

        Key key = getKeyFromKeystore();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] encryptedPasswordBytes = Base64.getDecoder().decode(encryptedPassword);
        byte[] decryptedPasswordBytes = cipher.doFinal(encryptedPasswordBytes);

        return new String(decryptedPasswordBytes);
    }

    private Key getKeyFromKeystore() throws Exception {
        return (Key) keystore.getKey("alias", "password".toCharArray());
    }
}