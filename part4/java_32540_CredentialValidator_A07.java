import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class java_32540_CredentialValidator_A07 {
    public static void main(String[] args) {
        String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4s9D+IkBfG/hWgDJ\n" +
                "gQqWp/BQfX2zvXD5H1Rg9/51HsZ/2E676fK7zxKRlD8+jGzv2zqxDlZ6Mk\n" +
                "13HxhqgkzR1DzJx+Q4+D2xFx0D96kQC3l7bH5lf9sKK463Fk2f3Xt/+E\n" +
                "BZpXz1sG73HX6s2QX5gJHVk87JD3+KzDgXEWzJk811g74pZwEuB8QQv+\n" +
                "rF217qwLjV4+721QsFs6Egw0fD9vzlw23h6H82FH6nJ/3R6QH7f/w0\n" +
                "gZtNH0JKqnNp8wbBZbPjBzZi52k9Qs2g4/9v1fZ/wIDAQAB\n" +
                "-----END PUBLIC KEY-----\n";

        String signature = "-----BEGIN SIGNATURE-----\n" +
                "MFkwEAAQ==\n" +
                "-----END SIGNATURE-----\n";

        byte[] data = "Hello, World!".getBytes();

        try {
            PublicKey publicKey = getPublicKeyFromString(publicKey);
            Signature sig = Signature.getInstance("SHA1withRSA");
            sig.initVerify(publicKey);
            sig.update(data);

            boolean verified = sig.verify(Base64.getDecoder().decode(signature));

            if (verified) {
                System.out.println("The signature is valid.");
            } else {
                System.out.println("The signature is not valid.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static PublicKey getPublicKeyFromString(String key) throws InvalidKeySpecException {
        byte[] keyBytes = key.getBytes();
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(keySpec);
        return publicKey;
    }
}