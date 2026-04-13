import java.security.PublicKey;
import java.security.Key;
import java.security.Signature;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.math.BigInteger;

public class java_41606_CredentialValidator_A08 {
    public static void main(String[] args) throws Exception {
        String privateKeyPath = "privateKey.pem";
        String publicKeyPath = "publicKey.pem";
        String dataToSign = "Hello World";

        byte[] privateKeyBytes = Files.readAllBytes(Paths.get(privateKeyPath));
        byte[] publicKeyBytes = Files.readAllBytes(Paths.get(publicKeyPath));

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.getPrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
        PublicKey publicKey = keyFactory.getPublic(new X509EncodedKeySpec(publicKeyBytes));

        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(privateKey);
        signature.update(dataToSign.getBytes());

        byte[] signatureBytes = signature.sign();
        System.out.println("Signature: " + new BigInteger(1, signatureBytes).toString(16));

        signature.initVerify(publicKey);
        signature.update(dataToSign.getBytes());

        System.out.println("Verification Result: " + (signature.verify() ? "Signature Verified" : "Signature Not Verified"));
    }
}