import java.security.PublicKey;
import java.security.Signature;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

public class java_42126_CredentialValidator_A08 {
    public static void main(String[] args) throws Exception {
        // Step 1: Generate a key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // RSA keys are 2048 bits long
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Step 2: Generate a signature
        String message = "Hello, World!";
        Signature signature = Signature.getInstance("SHA256WithRSA");
        signature.initSign(privateKey);
        signature.update(message.getBytes());
        byte[] signatureBytes = signature.sign();

        // Step 3: Verify the signature
        Signature verificationSignature = Signature.getInstance("SHA256WithRSA");
        verificationSignature.initVerify(publicKey);
        verificationSignature.update(message.getBytes());
        boolean isVerified = verificationSignature.verify(signatureBytes);

        System.out.println("Is verified? " + isVerified);
    }
}