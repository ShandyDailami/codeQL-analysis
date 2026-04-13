import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_27390_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "src/main/resources/sample.xml";

        try {
            FileInputStream fis = new FileInputStream(new File(xmlFile));
            KeyStore ks = KeyStore.getInstance("JKS");
            fis.read(ks);
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser(new org.xml.sax.InputSource(new FileInputStream(xmlFile)));
            saxParser.setEntityResolver(new MyEntityResolver());
            saxParser.parse(new File(xmlFile), new MyHandler());

            fis.close();
        } catch (KeyStoreException | CertificateException | ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            // Handle start element
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Handle end element
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Handle characters
        }
    }

    static class MyEntityResolver implements javax.xml.parsers.EntityResolver {
        @Override
        public org.xml.sax.InputSource resolveEntity(String systemId) throws SAXException, IOException {
            // Handle resolve entity
            return new org.xml.sax.InputSource(new StringReader(""));
        }
    }
}