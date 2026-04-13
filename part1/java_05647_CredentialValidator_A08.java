import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class java_05647_CredentialValidator_A08 {

    // Key to use for HMAC
    private static final String HMAC_KEY = "my-hmac-key";

    // Public Key to use for signature
    private static final PublicKey PUBLIC_KEY = ...; // Load your public key here

    // Method to validate the password
    public boolean validatePassword(String password) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        // Hash the password
        byte[] hash = hashPassword(password);

        // Sign the hash with the private key
        byte[] signature = signHash(hash);

        // Verify the signature with the public key
        return verifySignature(signature);
    }

    // Method to hash the password
    private byte[] hashPassword(String password) throws NoSuchAlgorithmException {
        return HMAC.getInstance("HmacSHA256").doFinal(password.getBytes());
    }

    // Method to sign the hash
    private byte[] signHash(byte[] hash) throws InvalidKeyException, NoSuchAlgorithmException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(HMAC_KEY.getBytes(), "HmacSHA256"));
        return mac.doFinal(hash);
    }

    // Method to verify the signature
    private boolean verifySignature(byte[] signature) throws InvalidKeyException, NoSuchAlgorithmException, SignatureException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(HMAC_KEY.getBytes(), "HmacSHA256"));
        return mac.doFinal(signature)
                .equals(signHash(hashPassword(signature.toString())));
    }
}