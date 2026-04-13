import java.security.PublicKey;
import java.security.Signature;
import java.security.SecureRandom;

public class java_22409_CredentialValidator_A08 {

    public static void main(String[] args) throws Exception {
        // Step 1: Generate a private key and a public key
        SecureRandom secureRandom = new SecureRandom();
        PublicKey publicKey = KeyPairUtil.generateKeyPair(secureRandom);
        PrivateKey privateKey = KeyPairUtil.generatePrivateKey(publicKey, secureRandom);

        // Step 2: Generate some data to be signed
        byte[] data = "Hello, World!".getBytes();

        // Step 3: Sign the data
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(secureRandom, privateKey);
        signature.update(data);
        byte[] signatureBytes = signature.sign();

        // Step 4: Verify the signature
        Signature verificationSignature = Signature.getInstance("SHA1withRSA");
        verificationSignature.initVerify(publicKey);
        verificationSignature.update(data);

        boolean isValid = verificationSignature.verify(signatureBytes);
        System.out.println("Signature is valid: " + isValid);
    }

    public static class KeyPairUtil {

        public static PublicKey generateKeyPair(SecureRandom secureRandom) {
            KeyPairGenerator keyPairGenerator = null;
            try {
                keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            keyPairGenerator.initialize(1024, secureRandom);
            return keyPairGenerator.genKeyPair().getPublic();
        }

        public static PrivateKey generatePrivateKey(PublicKey publicKey, SecureRandom secureRandom) {
            KeyPair keyPair = KeyStore.getInstance("JKS").generateKeyPair(publicKey, secureRandom);
            return keyPair.getPrivate();
        }
    }
}