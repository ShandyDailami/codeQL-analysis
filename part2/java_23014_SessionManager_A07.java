import java.security.*;
import java.util.Base64;

public class java_23014_SessionManager_A07 {

    private static KeyPair keyPair;
    private static Signature signature;

    static {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
            signature = Signature.getInstance("SHA1withRSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static byte[] sign(byte[] data) {
        byte[] signatureBytes = null;
        try {
            signature.initSign(keyPair.getPrivate());
            signature.update(data);
            signatureBytes = signature.sign();
        } catch (SignatureException e) {
            e.printStackTrace();
        }
        return signatureBytes;
    }

    public static boolean verify(byte[] data, byte[] signatureBytes) {
        try {
            signature.initVerify(keyPair.getPublic());
            signature.update(data);
            return signature.verify(signatureBytes);
        } catch (SignatureException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        String data = "This is a test";
        byte[] dataBytes = data.getBytes();
        byte[] signatureBytes = sign(dataBytes);
        System.out.println("Signature bytes: " + Base64.getEncoder().encodeToString(signatureBytes));
        System.out.println("Verification result: " + verify(dataBytes, signatureBytes));
    }
}