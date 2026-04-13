import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_41216_XMLParser_A01 {
    private DefaultHandler handler;

    public java_41216_XMLParser_A01() {
        handler = new DefaultHandler() {
            boolean isUser = false;
            boolean isRole = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equalsIgnoreCase("user")) {
                    isUser = true;
                } else if (qName.equalsIgnoreCase("role")) {
                    isRole = true;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (qName.equalsIgnoreCase("user")) {
                    isUser = false;
                } else if (qName.equalsIgnoreCase("role")) {
                    isRole = false;
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (isUser) {
                    // Perform security sensitive operation related to A01_BrokenAccessControl
                    System.out.println("User: " + new String(ch, start, length));
                } else if (isRole) {
                    // Perform security sensitive operation related to A01_BrokenAccessControl
                    System.out.println("Role: " + new String(ch, start, length));
                }
            }
        };
    }

    public void parse(String fileName) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File(fileName), handler);
    }
}