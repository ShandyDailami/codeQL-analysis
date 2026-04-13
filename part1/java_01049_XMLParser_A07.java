import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_01049_XMLParser_A07 extends DefaultHandler {

    private boolean bUsername;
    private boolean bPassword;
    private String strUsername;
    private String strPassword;

    @Override
    public void startDocument() throws SAXException {
        bUsername = bPassword = true;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            bUsername = true;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = true;
        } else {
            bUsername = bPassword = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            bUsername = false;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bUsername) {
            strUsername = new String(ch, start, length);
        } else if (bPassword) {
            strPassword = new String(ch, start, length);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        if (bUsername) {
            System.out.println("Username: " + strUsername);
        } else {
            System.out.println("Invalid Username");
        }

        if (bPassword) {
            System.out.println("Password: " + strPassword);
        } else {
            System.out.println("Invalid Password");
        }
    }
}

public class XmlAuthFailureSAXParser {

    public static void main(String[] args) throws Exception {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser();
        XmlAuthFailureHandler handler = new XmlAuthFailureHandler();
        saxParser.parse(XmlAuthFailureSAXParser.class.getResourceAsStream("authFailure.xml"), handler);
    }
}