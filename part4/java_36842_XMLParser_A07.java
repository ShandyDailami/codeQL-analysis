import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_36842_XMLParser_A07 {
    public static void main(String[] args) {
        // Startup
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(true);

        // Creating handler
        MyHandler handler = new MyHandler();

        // Parsing
        try {
            parser.parse("src/authfailure.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean isUser = false;
    boolean isPassword = false;
    boolean isRole = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("User")) {
            isUser = true;
        } else if (qName.equalsIgnoreCase("Password")) {
            isPassword = true;
        } else if (qName.equalsIgnoreCase("Role")) {
            isRole = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isUser) {
            System.out.println("User: " + new String(ch, start, length));
            isUser = false;
        } else if (isPassword) {
            System.out.println("Password: " + new String(ch, start, length));
            isPassword = false;
        } else if (isRole) {
            System.out.println("Role: " + new String(ch, start, length));
            isRole = false;
        }
    }
}