import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class java_03325_CredentialValidator_A08 {

    public static void main(String[] args) throws Exception {
        String message = "A message to be verified";
        String signatureString = "A signature";

        byte[] signatureBytes = Base64.getDecoder().decode(signatureString);
        PrivateKey privateKey = getPrivateKey();

        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(privateKey);
        signature.update(message.getBytes());

        boolean isValid = signature.verify(signatureBytes);
        System.out.println("Is signature valid? " + isValid);
    }

    private static PrivateKey getPrivateKey() throws Exception {
        String keyString = "MIICXAIBAAKCAgEA1... (Your private key here)";
        byte[] keyBytes = Base64.getDecoder().decode(keyString);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(keySpec);
        return privateKey;
    }
}