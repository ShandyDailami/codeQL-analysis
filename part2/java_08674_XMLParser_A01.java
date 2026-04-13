import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;

public class java_08674_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Parse XML file
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(true);

            // Create a handler
            MyHandler handler = new MyHandler();
            saxParser.parse(new File("input.xml"), handler);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean accessControl = false;
    private boolean accessUser = false;
    private boolean accessRole = false;
    private boolean accessPassword = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("access")) {
            accessControl = true;
            accessUser = true;
            accessRole = true;
            accessPassword = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("access")) {
            accessControl = false;
            accessUser = false;
            accessRole = false;
            accessPassword = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (accessControl) {
            System.out.println("Access Control: " + new String(ch, start, length));
        }
        if (accessUser) {
            System.out.println("Access User: " + new String(ch, start, length));
        }
        if (accessRole) {
            System.out.println("Access Role: " + new String(ch, start, length));
        }
        if (accessPassword) {
            System.out.println("Access Password: " + new String(ch, start, length));
        }
    }
}