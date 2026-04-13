import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLResourceLoader;

import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

public class java_01252_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            if (!xmlFile.exists()) {
                System.out.println("File does not exist!");
                System.exit(-1);
            }

            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream("truststore.jks"), "truststorepassword".toCharArray());

            XMLParser parser = XMLResourceLoader.newSAXParser();
            parser.setEntityResolver(new MyEntityResolver(trustStore));
            parser.setContentHandler(new MyContentHandler());
            parser.parse(xmlFile);

        } catch (KeyStoreException | CertificateException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyEntityResolver extends DefaultHandler {
        private KeyStore trustStore;

        public java_01252_XMLParser_A08(KeyStore trustStore) {
            this.trustStore = trustStore;
        }

        @Override
        public InputSource resolveEntity(String url) throws SAXException {
            try {
                return new InputSource(new StringReader(url));
            } catch (IOException e) {
                throw new SAXException("Cannot load entity: " + url, e);
            }
        }
    }

    static class MyContentHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            // TODO: Insert your code here.
            // Implement the security-sensitive operations related to A08_IntegrityFailure.
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // TODO: Insert your code here.
            // Implement the security-sensitive operations related to A08_IntegrityFailure.
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // TODO: Insert your code here.
            // Implement the security-sensitive operations related to A08_IntegrityFailure.
        }
    }
}