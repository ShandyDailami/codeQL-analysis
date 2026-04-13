import java.security.GeneralSecurityException;
import java.security.PasswordAuthentication;
import java.util.Base64;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class java_34264_CredentialValidator_A07 implements CallbackHandler {
    private static final String KEY = "ThisIsASecretKey";
    private final BufferedBlockCipher cipher = new AESEngine();
    private PasswordAuthentication passwordAuthentication;

    public java_34264_CredentialValidator_A07() {
        this.cipher.init(true, new KeyParameter(KEY.getBytes()));
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return passwordAuthentication;
    }

    @Override
    public void initialize(String s, Callback[] callbacks) throws UnsupportedCallbackException {
        passwordAuthentication = new PasswordAuthentication(s.getBytes(), null);
    }

    public String encrypt(String plainText) throws GeneralSecurityException {
        byte[] encrypted = cipher.doFinal(plainText.getBytes());
        byte[] iv = cipher.getIV();
        byte[] encryptedIv = cipher.doFinal(iv);
        byte[] encryptedData = new byte[encrypted.length + encryptedIv.length];
        System.arraycopy(encrypted, 0, encryptedData, 0, encrypted.length);
        System.arraycopy(encryptedIv, 0, encryptedData, encrypted.length, encryptedIv.length);
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public String decrypt(String encryptedText) throws GeneralSecurityException {
        byte[] encryptedData = Base64.getDecoder().decode(encryptedText);
        byte[] iv = cipher.getIV();
        byte[] encryptedIv = cipher.doFinal(iv);
        byte[] decryptedData = cipher.doFinal(encryptedData, encryptedIv.length);
        return new String(decryptedData);
    }
}