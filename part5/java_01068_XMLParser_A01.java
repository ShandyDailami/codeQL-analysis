import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_01068_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser(null);
        SAXHandler sh = new SAXHandler();

        sp.parse(new File("sample.xml"), sh);
    }
}

class SAXHandler extends DefaultHandler {
    boolean bAccessControl = false;

    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("AccessControl")) {
            bAccessControl = true;
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("AccessControl")) {
            bAccessControl = false;
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bAccessControl) {
            String accessControl = new String(ch, start, length);
            // Do some security-sensitive operations related to AccessControl
            // e.g., check for broken access control mechanisms
        }
    }
}