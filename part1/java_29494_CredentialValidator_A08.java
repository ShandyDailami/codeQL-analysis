import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.util.Base64;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.usernamepassword.UsernamePasswordAuthenticationToken;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class java_29494_CredentialValidator_A08 implements CredentialValidator {

    private Key key;
    private String algorithm;

    public java_29494_CredentialValidator_A08(String algorithm) throws Exception {
        this.algorithm = algorithm;
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        key = keyGenerator.generateKey();
    }

    @Override
    public UsernamePasswordAuthenticationToken validate(CallbackHandler callbackHandler) throws Exception {
        // Obtain callback and set username/password.
        UsernamePasswordAuthenticationToken callback = new UsernamePasswordAuthenticationToken("", "");
        callbackHandler.handle(callback);

        String username = callback.getIdentifier();
        char[] password = (char[]) callback.getCredentials();

        // Perform integrity check.
        String expected = encrypt(username, password);
        if (!expected.equals(callback.getCredentials())) {
            throw new AuthenticationFailedException("Integrity check failed");
        }

        return callback;
    }

    private String encrypt(String username, char[] password) {
        String encryptedPassword = "";
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encryptedPassword = Base64.getEncoder().encodeToString(cipher.doFinal(password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedPassword;
    }
}