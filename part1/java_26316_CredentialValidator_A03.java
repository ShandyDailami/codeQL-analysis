import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.security.auth.DestroyedCredentialException;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_26316_CredentialValidator_A03 implements CredentialValidator {

    private KeyStore keystore;
    private Key privateKey;

    public java_26316_CredentialValidator_A03(String keystorePath, char[] keystorePassword,
            String privateKeyPath, char[] privateKeyPassword)
            throws KeyStoreException, IOException, CertificateException,
            UnrecoverableKeyException, NoSuchAlgorithmException {
        this.keystore = KeyStore.getInstance("JKS");
        this.keystore.load(new FileInputStream(keystorePath), keystorePassword);
        this.privateKey = this.keystore.getKey(privateKeyPath, privateKeyPassword);
    }

    @Override
    public boolean validate(CallbackHandler callbackHandler,
            Credential credential) throws DestroyedCredentialException,
            InvalidCredentialException {
        return false;
    }

    @Override
    public boolean getPassword(char[] password) throws UnsupportedCallbackException,
            InvalidKeyException {
        return false;
    }

    public String encrypt(String data) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, this.privateKey);
        return new String(cipher.doFinal(data.getBytes()));
    }
}