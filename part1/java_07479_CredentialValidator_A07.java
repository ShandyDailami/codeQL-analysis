// Start of code

import java.security.PublicKey;
import java.security.Signature;
import java.security.Key;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Base64.Decoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class java_07479_CredentialValidator_A07 {
    private static final String DES = "DES";
    private static final String DEFAULT_KEY = "12345678";
    private static SecretKey key;
    private static Cipher cipher;

    public static void main(String[] args) throws Exception {
        init();

        String text = "Hello, World!";
        byte[] btext = text.getBytes("UTF-8");
        byte[] bkey = key.getEncoded();

        cipher.doFinal(btext, 0, btext.length, bkey, new byte[0]);

        String encrypted = Base64.getEncoder().encodeToString(cipher.getOutput());
        System.out.println("Encrypted text: " + encrypted);

        cipher.doFinal(encrypted.getBytes("UTF-8"), 0, encrypted.length(), bkey, new byte[0]);
        System.out.println("Decrypted text: " + new String(cipher.getOutput(), "UTF-8"));
    }

    private static void init() throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance(DES);
        kg.init(56); // AES requires 112 or 168 bits
        key = kg.generateKey();

        cipher = Cipher.getInstance(DES);
        cipher.init(Cipher.ENCRYPT_MODE, key);
    }
}

// End of code