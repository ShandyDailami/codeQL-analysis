import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Signature;
import java.security.SignatureException;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_04593_XMLParser_A01 {
    private static final String KEYSTORE_FILE = "keystore.p12";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String KEY_ALIAS = "key";

    public void parse(String file) throws Exception {
        // Load the private key from the keystore
        KeyStore keystore = KeyStore.getInstance("PKCS12");
        InputStream inputStream = new FileInputStream(KEYSTORE_FILE);
        keystore.load(inputStream, KEYSTORE_PASSWORD.toCharArray());
        Certificate certificate = keystore.getCertificate(KEY_ALIAS);

        // Verify the certificate
        Signature signature = Signature.getInstance("SHA1WithRSA");
        signature.initVerify(certificate);
        signature.verify(inputStream);

        // SAX parser factory
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        // SAX parser
        parser.parse(file, new XMLHandler());
    }

    public static class XMLHandler implements javax.xml.parsers.SAXHandler {
        public void startElement(String uri, String localName, String qName,
                javax.xml.parsers.SAXEvent saxEvent) throws javax.xml.parsers.SAXException {
            System.out.println("Start element: " + qName);
        }

        public void endElement(String uri, String localName, String qName,
                javax.xml.parsers.SAXEvent saxEvent) throws javax.xml.parsers.SAXException {
            System.out.println("End element: " + qName);
        }

        public void characters(char[] ch, int start, int length, javax.xml.parsers.SAXEvent saxEvent)
                throws javax.xml.parsers.SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}