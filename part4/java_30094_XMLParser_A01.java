import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_30094_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());

            File inputFile = new File("input.xml");
            parser.parse(inputFile, XmlHandler.getHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XmlHandler extends DefaultHandler {
    private static final String[] sensitiveInfo = {"username", "password", "address"};

    public static DefaultHandler getHandler() {
        return new XmlHandler();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        for (String sensitive : sensitiveInfo) {
            if (localName.equals(sensitive)) {
                System.out.println("Sensitive information found!");
                return;
            }
        }
        System.out.println("Start element: " + localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("username")) {
            System.out.println("End element: " + localName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        System.out.println("Character data: " + value);
    }
}