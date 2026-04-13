import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class java_03748_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            // Create an instance of the XMLHandler
            MyHandler myHandler = new MyHandler();

            // Parse XML
            saxParser.parse("src/main/resources/sample.xml", myHandler);

            // Get the parsed data from the handler
            String integrity = myHandler.getIntegrity();
            System.out.println("Integrity: " + integrity);

        } catch (ParserConfigurationException | SAXException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }
    }

    // Define the XMLHandler
    static class MyHandler extends javax.xml.parsers.ContentHandler {
        private String integrity;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            // TODO Auto-generated method stub
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // TODO Auto-generated method stub
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // TODO Auto-generated method stub
        }

        public String getIntegrity() {
            return integrity;
        }

        public void setIntegrity(String integrity) {
            this.integrity = integrity;
        }
    }
}