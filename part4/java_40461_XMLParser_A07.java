import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.Xerces2SAXParser;

public class java_40461_XMLParser_A07 {

    private static class MyHandler extends DefaultHandler {
        public void startDocument() {
            // Do nothing, as we only care about security-sensitive operations.
        }

        public void endDocument() {
            // Do nothing, as we only care about security-sensitive operations.
        }

        public void startElement(String uri, String localName, String qName,
                javax.xml.namespace.QName qNs, org.xml.sax.Attributes atts) {
            // Do nothing, as we only care about security-sensitive operations.
        }

        public void endElement(String uri, String localName, String qName) {
            // Do nothing, as we only care about security-sensitive operations.
        }
    }

    public static void main(String[] args) {
        try {
            SAXHelper helper = new Xerces2SAXParser();
            XMLReader reader = helper.getXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse("sample.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}