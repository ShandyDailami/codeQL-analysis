import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;
import javax.crypto.Cipher;

public class java_18007_CredentialValidator_A08 {
    private KeyStore keyStore;

    public java_18007_CredentialValidator_A08(String keystoreFile, String keystorePassword) throws Exception {
        this.keyStore = KeyStore.getInstance("JKS");
        this.keyStore.load(getClass().getResourceAsStream(keystoreFile), keystorePassword.toCharArray());
    }

    public boolean isKeyPairValid(String alias, String password) throws Exception {
        Key key = this.keyStore.getKey(alias, password.toCharArray());
        return key != null;
    }

    public boolean isSignatureValid(String alias, String password, String data, String signatureBase64) throws Exception {
        PrivateKey privateKey = (PrivateKey) this.keyStore.getKey(alias, password.toCharArray());
        Certificate certificate = this.keyStore.getCertificate(alias);

        byte[] dataBytes = data.getBytes();
        byte[] signatureBytes = Base64.getDecoder().decode(signatureBase64);

        Cipher cipher = Cipher.getInstance("SHA1withRSA");
        cipher.init(Cipher.VERIFY, certificate);

        return cipher.doVerify(signatureBytes);
    }
}