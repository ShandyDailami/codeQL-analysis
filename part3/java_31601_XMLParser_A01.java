import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_31601_XMLParser_A01 {

    // SAX parser
    private SAXParser saxParser;

    // Access control mechanism
    private AccessControl accessControl;

    public java_31601_XMLParser_A01(SAXParser saxParser, AccessControl accessControl) {
        this.saxParser = saxParser;
        this.accessControl = accessControl;
    }

    public void parseFile(String fileName) throws SAXException, IOException {
        File xmlFile = new File(fileName);
        XMLReader reader = XMLReaderFactory.createXMLReader();
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName) throws SAXException {
                // Check access control
                if (!accessControl.checkAccess(localName)) {
                    throw new SAXException("Access to " + localName + " is restricted.");
                }
            }
        };
        reader.setContentHandler(handler);
        reader.parse(xmlFile);
    }

    public static void main(String[] args) {
        // Initialize SAXParser and AccessControl
        SAXParser saxParser = new SAXParser();
        AccessControl accessControl = new AccessControl();
        SecurityChecker securityChecker = new SecurityChecker(saxParser, accessControl);

        // Parse XML file
        try {
            securityChecker.parseFile("example.xml");
            System.out.println("File parsed successfully.");
        } catch (Exception e) {
            System.out.println("Error parsing file: " + e.getMessage());
        }
    }
}