import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_05553_XMLParser_A07 extends DefaultHandler {
    private boolean usernameFound = false;
    private boolean passwordFound = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            usernameFound = true;
        } else if (qName.equalsIgnoreCase("password")) {
            passwordFound = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            usernameFound = false;
        } else if (qName.equalsIgnoreCase("password")) {
            passwordFound = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (usernameFound) {
            System.out.println("Username: " + new String(ch, start, length));
        } else if (passwordFound) {
            System.out.println("Password: " + new String(ch, start, length));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse("src/main/resources/example.xml", new SensitiveDataHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}