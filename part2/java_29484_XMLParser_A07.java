import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_29484_XMLParser_A07 extends DefaultHandler {

    private boolean authFailure = false;
    private int authFailureCount = 0;

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            authFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            authFailure = false;
            authFailureCount = 0;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (authFailure) {
            authFailureCount++;
        }
    }

    public void parse(String fileName) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(null);
            sp.parse(fileName, this);
            System.out.println("AuthFailure count: " + authFailureCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AuthFailureHandler handler = new AuthFailureHandler();
        handler.parse("A07_AuthFailure.xml");
    }
}