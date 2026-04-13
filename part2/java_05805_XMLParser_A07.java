import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_05805_XMLParser_A07 extends DefaultHandler {

    private boolean bAuthFailure = false;
    private boolean bUser = false;
    private boolean bPassword = false;
    private boolean bRole = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("USER")) {
            bUser = true;
        } else if (qName.equalsIgnoreCase("PASSWORD")) {
            bPassword = true;
        } else if (qName.equalsIgnoreCase("ROLE")) {
            bRole = true;
        } else if (qName.equalsIgnoreCase("AUTHFAILURE")) {
            bAuthFailure = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("USER")) {
            bUser = false;
        } else if (qName.equalsIgnoreCase("PASSWORD")) {
            bPassword = false;
        } else if (qName.equalsIgnoreCase("ROLE")) {
            bRole = false;
        } else if (qName.equalsIgnoreCase("AUTHFAILURE")) {
            bAuthFailure = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bUser) {
            // Handle user data
        } else if (bPassword) {
            // Handle password data
        } else if (bRole) {
            // Handle role data
        } else if (bAuthFailure) {
            // Handle authentication failure
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser();

        XMLParser parser = new XMLParser();
        saxParser.parse(Class.forName("your_file_name").getResourceAsStream(), parser);
    }
}