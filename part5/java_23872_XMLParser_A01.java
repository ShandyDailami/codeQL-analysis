import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_23872_XMLParser_A01 extends DefaultHandler {

    private boolean isInElement = false;

    private boolean isSecurityCheckActive = false;

    private static final String SECURITY_CHECK = "<securityCheck>true</securityCheck>";

    private boolean isInSecurityCheck = false;

    private boolean isAccessControlActive = false;

    private static final String ACCESS_CONTROL = "<accessControl>true</accessControl>";

    private boolean isInAccessControl = false;

    public java_23872_XMLParser_A01() {
        SAXParser saxParser = null;
        try {
            saxParser = SAXParserFactory.newInstance().newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
        } catch (XMLReaderException e) {
            e.printStackTrace();
        }
        saxParser.setContentHandler(this);
        xmlReader.setContentHandler(this);
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("element")) {
            isInElement = true;
            if (isSecurityCheckActive) {
                System.out.println("Security check detected");
                isSecurityCheckActive = false;
            }
            if (isAccessControlActive) {
                System.out.println("Access control detected");
                isAccessControlActive = false;
            }
        }
        if (qName.equals("securityCheck")) {
            isSecurityCheckActive = true;
        }
        if (qName.equals("accessControl")) {
            isAccessControlActive = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("element")) {
            isInElement = false;
        }
        if (qName.equals("securityCheck") && isSecurityCheckActive) {
            System.out.println("Security check ended");
            isSecurityCheckActive = false;
        }
        if (qName.equals("accessControl") && isAccessControlActive) {
            System.out.println("Access control ended");
            isAccessControlActive = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            String text = new String(ch, start, length);
            System.out.println("Element text: " + text);
        }
        if (isInSecurityCheck && isSecurityCheckActive) {
            System.out.println("Security check text: " + text);
            isSecurityCheckActive = false;
        }
        if (isInAccessControl && isAccessControlActive) {
            System.out.println("Access control text: " + text);
            isAccessControlActive = false;
        }
    }

    public static void main(String[] args) {
        new MyXMLParser();
    }

}