import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class java_24275_CredentialValidator_A03 {

    // This is the key that is used to encrypt and decrypt the passwords.
    private final Key key;

    public java_24275_CredentialValidator_A03(String key) {
        this.key = convertKey(key);
    }

    private Key convertKey(String key) {
        byte[] bytes = key.getBytes();
        return new SecretKeySpec(bytes, "AES");
    }

    public String encryptPassword(String password) throws Exception {
        String encryptedPassword = "";
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        encryptedPassword = Base64.getEncoder().encodeToString(cipher.doFinal(password.getBytes("UTF-8")));
        return encryptedPassword;
    }

    public String decryptPassword(String encryptedPassword) throws Exception {
        String decryptedPassword = "";
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        decryptedPassword = new String(cipher.doFinal(Base64.getDecoder().decode(encryptedPassword)), "UTF-8");
        return decryptedPassword;
    }
}