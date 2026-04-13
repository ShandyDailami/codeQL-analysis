import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class java_07091_XMLParser_A07 {
    private static final String algorithm = "AES";
    private static final int keysize = 256;

    public static void main(String[] args) throws Exception {
        // Generate a secure key
        Key key = generateKey();

        // Create an XML reader
        XMLReader reader = createReader();

        // Create a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML
        Document doc = builder.parse(args[0]);
        doc.getDocumentElement().normalize();

        reader.setContentHandler(new ContentHandler(key));
        reader.parse(new InputSource(new StringReader(doc.getDocumentElement().getNodeName())));
    }

    private static Key generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        keyGenerator.init(keysize);
        SecretKey secretKey = keyGenerator.generateKey();
        return new SecretKeySpec(secretKey.getEncoded(), algorithm);
    }

    private static XMLReader createReader() throws ParserConfigurationException {
        return XMLReaderFactory.createXMLReader();
    }

    private static class ContentHandler extends DefaultHandler {
        private final Cipher cipher;
        private final String secret;

        public java_07091_XMLParser_A07(Key key) throws Exception {
            this.cipher = Cipher.getInstance(algorithm);
            this.cipher.init(Cipher.ENCRYPT_MODE, key);
            this.secret = generateSecret();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Encrypt the element
            cipher.update(generateEncryptedElement(qName));
        }

        private String generateEncryptedElement(String element) throws Exception {
            return new String(cipher.doFinal(element.getBytes()));
        }

        private String generateSecret() {
            SecureRandom random = new SecureRandom();
            byte[] bytes = new byte[16];
            random.nextBytes(bytes);
            return new String(cipher.doFinal(bytes));
        }
    }
}