import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Base64;

import javax.crypto.Cipher;

public class java_38930_CredentialValidator_A07 {

    private KeyStore keyStore;
    private Key privateKey;

    public java_38930_CredentialValidator_A07(KeyStore keyStore, Key privateKey) {
        this.keyStore = keyStore;
        this.privateKey = privateKey;
    }

    public boolean isValidSignature(String data, String signature, String algorithm) {
        try {
            Signature sig = Signature.getInstance(algorithm);
            sig.initVerify(this.keyStore.getKey(signature));
            sig.update(data.getBytes());
            return sig.verify(Base64.getDecoder().decode(signature));
        } catch (Exception e) {
            System.out.println("Invalid signature: " + e.getMessage());
            return false;
        }
    }

    public String createSignature(String data, String algorithm) {
        try {
            Signature sig = Signature.getInstance(algorithm);
            sig.initSign(this.keyStore.getKey(data, "password".toCharArray()));
            sig.update(data.getBytes());
            byte[] signature = sig.sign();
            return Base64.getEncoder().encodeToString(signature);
        } catch (Exception e) {
            System.out.println("Failed to create signature: " + e.getMessage());
            return null;
        }
    }

    public boolean isValidCredential(String data, String signature, String algorithm) {
        if (!isValidSignature(data, signature, algorithm)) {
            System.out.println("Invalid signature");
            return false;
        }

        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, this.keyStore.getKey(data, "password".toCharArray()));
            byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(data));
            return new String(decryptedData).equals(data);
        } catch (Exception e) {
            System.out.println("Invalid credential: " + e.getMessage());
            return false;
        }
    }

    public String createCredential(String data, String algorithm) {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, this.keyStore.getKey(data, "password".toCharArray()));
            byte[] encryptedData = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedData);
        } catch (Exception e) {
            System.out.println("Failed to create credential: " + e.getMessage());
            return null;
        }
    }

}