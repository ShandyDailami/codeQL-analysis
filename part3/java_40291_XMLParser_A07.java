import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.crypto.KeySelector;
import javax.xml.crypto.KeySelectorResult;
import javax.xml.crypto.CryptoContext;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class java_40291_XMLParser_A07 {

    private static final String KEY = "ThisIsASecretKey";

    public static void main(String[] args) throws Exception {
        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = spf.newSAXParser();

        // Create a Crypto Context with a Secret Key
        CryptoContext cryptoContext = CryptoContext.getInstance("AES", "AES/ECB/NoPadding");
        KeySelector keySelector = new KeySelector() {
            @Override
            public KeySelectorResult selectKey(byte[] bs) {
                return new KeySelectorResult(new SecretKeySpec(KEY.getBytes(), "AES"));
            }
        };
        cryptoContext.setKeySelector(keySelector);

        // Encrypt the XML
        String encryptedXml = encrypt(xml, cryptoContext);

        saxParser.parse(new StringReader(encryptedXml), new SAXHandler());
    }

    private static String encrypt(String value, CryptoContext context) throws Exception {
        Cipher cipher = context.getCipher("AES/ECB/NoPadding");
        return new String(cipher.doFinal(value.getBytes()));
    }
}