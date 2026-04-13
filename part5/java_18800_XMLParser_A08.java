import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_18800_XMLParser_A08 extends DefaultHandler {

    private boolean nameFound = false;
    private boolean passwordFound = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            nameFound = true;
        } else if (qName.equalsIgnoreCase("password")) {
            passwordFound = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            nameFound = false;
        } else if (qName.equalsIgnoreCase("password")) {
            passwordFound = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (nameFound) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (passwordFound) {
            System.out.println("Password: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File("src/main/resources/sensitiveData.xml"), new SensitiveDataHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}