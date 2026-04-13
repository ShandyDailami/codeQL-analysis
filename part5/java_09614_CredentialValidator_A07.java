import java.security.PrivateKey;
import java.security.Signature;
import java.security.Key;
import java.security.PublicKey;
import java.util.Base64;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.math.BigInteger;

public class java_09614_CredentialValidator_A07 {

    public static void main(String[] args) throws Exception {

        // Load the public key
        PublicKey publicKey = loadPublicKey("publicKey.der");

        // Load the private key
        PrivateKey privateKey = loadPrivateKey("privateKey.der");

        // Load the signature
        String signatureBase64 = new String(Files.readAllBytes(Paths.get("signature.sig")));

        // Validate the signature
        validateSignature(signatureBase64, publicKey, "message.msg");
    }

    private static PublicKey loadPublicKey(String filename) throws Exception {
        byte[] keyBytes = Files.readAllBytes(Paths.get(filename));
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    private static PrivateKey loadPrivateKey(String filename) throws Exception {
        byte[] keyBytes = Files.readAllBytes(Paths.get(filename));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    private static void validateSignature(String signatureBase64, PublicKey publicKey, String message) throws Exception {
        byte[] signatureBytes = Base64.getDecoder().decode(signatureBase64);
        Signature signature = Signature.getInstance("SHA256WithRSA");
        signature.initVerify(publicKey);
        signature.verify(signatureBytes);

        System.out.println("Signature is valid: " + signature.verify(signatureBytes));
    }
}