import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class java_07779_CredentialValidator_A08 {

    // Assuming we have a function to generate a Public Key.
    // This is not included in the example, as it's assumed that we have a way to generate a public key.
    public static PublicKey getPublicKeyFromString(String key) throws InvalidKeySpecException {
        byte[] keyBytes = Base64.getDecoder().decode(key);
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(keyBytes));
    }

    public static boolean validateCredential(String publicKeyString, String signedData, String signatureString) {
        try {
            PublicKey publicKey = getPublicKeyFromString(publicKeyString);

            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initVerify(publicKey);
            signature.update(signedData.getBytes());

            byte[] signatureBytes = Base64.getDecoder().decode(signatureString);

            return signature.verify(signatureBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}