import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_13020_XMLParser_A08 extends DefaultHandler {

    private String lastElement;
    private static final String AUTHORITY = "A08_IntegrityFailure";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (AUTHORITY.equals(localName)) {
            // If the element matches, we are interested in the attributes
            String integrityAttribute = attributes.getValue("Integrity");
            if ("Failure".equals(integrityAttribute)) {
                // If the integrity attribute is set to Failure, it is a SecurityFailure
                System.out.println("Detected Security Failure");
            }
        }
        lastElement = localName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastElement = null;
    }

    public static void parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SecurityExample());
            parser.parse(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parse("sample.xml");
    }
}