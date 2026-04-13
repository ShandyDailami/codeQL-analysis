import java.security.*;

public class java_25051_SessionManager_A08 {

    // Private Key
    private Key privateKey;

    // Public Key
    private Key publicKey;

    public java_25051_SessionManager_A08() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(1024);
            KeyPair keys = keyGen.generateKeyPair();
            this.privateKey = keys.getPrivate();
            this.publicKey = keys.getPublic();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String sign(String data) {
        byte[] signatureBytes;
        try {
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initSign(privateKey);
            signature.update(data.getBytes());
            signatureBytes = signature.sign();
        } catch (SignatureException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        return Base64.getEncoder().encodeToString(signatureBytes);
    }

    public boolean verify(String data, String signature) {
        byte[] signatureBytes = Base64.getDecoder().decode(signature);

        try {
            Signature sig = Signature.getInstance("SHA1WithRSA");
            sig.initVerify(publicKey);
            sig.update(data.getBytes());

            return sig.verify(signatureBytes);
        } catch (SignatureException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}