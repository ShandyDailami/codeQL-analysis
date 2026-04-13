import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_22365_XMLParser_A01 {

    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore";
    private static final String KEYSTORE_PASSWORD = "keystorePassword";
    private static final String KEY_ALIAS = "keyAlias";

    public static void main(String[] args) throws Exception {
        KeyStore keystore = loadKeyStore(KEYSTORE_LOCATION, KEYSTORE_PASSWORD);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setValidating(false); // Disable validation
        SAXParser saxParser = saxParserFactory.newSAXParser(keystore);

        InputStream inputStream = new FileInputStream("/path/to/your/xml");
        XmlHandler xmlHandler = new XmlHandler();
        saxParser.parse(inputStream, xmlHandler);
        inputStream.close();
    }

    private static KeyStore loadKeyStore(String location, String password) throws KeyStoreException, CertificateException, NoSuchAlgorithmException {
        return KeyStore.getInstance("JKS");
    }

    private static class XmlHandler extends DefaultHandler {

        private boolean isNameTag = false;
        private String nameTag = null;

        @Override
        public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
            if (qualifiedName.equals("name")) {
                isNameTag = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
            if (qualifiedName.equals("name")) {
                isNameTag = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isNameTag) {
                nameTag = new String(ch, start, length);
            }
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            // Do nothing
        }

        @Override
        public void endPrefixMapping(String prefix) throws SAXException {
            // Do nothing
        }
    }
}