import java.security.SignatureException;
import java.security.Signature;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.Base64;
import java.security.Key;

public class java_08335_XMLParser_A08 {

    private static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
    private static final String KEYSTORE_TYPE = "PKCS12";
    private static final String KEYSTORE_PATH = "/path/to/your/keystore";
    private static final String KEYSTORE_PASSWORD = "your_password";
    private static final String CERTIFICATE_ALIAS = "your_certificate_alias";

    public static void main(String[] args) throws Exception {
        String xml = "<root><element attr='value'></element></root>";
        parseXml(xml);
    }

    public static void parseXml(String xml) throws Exception {
        KeyStore keystore = KeyStore.getInstance(KEYSTORE_TYPE);
        keystore.load(ClassLoader.getSystemResourceAsStream(KEYSTORE_PATH), KEYSTORE_PASSWORD.toCharArray());

        Key key = getKey(keystore, CERTIFICATE_ALIAS);
        validateSignature(xml, key);
    }

    private static Key getKey(KeyStore keystore, String alias) throws Exception {
        return keystore.getKey(alias, KEYSTORE_PASSWORD.toCharArray());
    }

    private static void validateSignature(String xml, Key key) throws SignatureException {
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(key);

        signature.update(xml.getBytes());

        if (!signature.verify()) {
            throw new SignatureException("Invalid signature");
        }
    }
}