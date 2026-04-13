// Start by importing the necessary libraries
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class java_27091_CredentialValidator_A08 {
    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";

    public boolean validate(String username, String password, String signature, String signatureBase64) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        // Step 1: Generate a key
        Key key = new SecretKeySpec(password.getBytes(), HMAC_SHA256_ALGORITHM);

        // Step 2: Create a HMAC with the key and the data
        Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
        mac.init(new SecretKeySpec(password.getBytes(), HMAC_SHA256_ALGORITHM));

        // Step 3: Verify the signature against the provided data
        byte[] signatureBytes = Base64.getDecoder().decode(signatureBase64);
        return mac.doFinal(username.getBytes()).equals(signatureBytes);
    }
}