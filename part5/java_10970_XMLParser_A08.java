import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_10970_XMLParser_A08 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File("src/main/resources/people.xml"), new XmlParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("person")) {
            System.out.println("Person Details: ");
            bName = true;
            bAge = true;
        } else if(bName) {
            System.out.print("Name: ");
            bName = false;
        } else if(bAge) {
            System.out.print("Age: ");
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("person")) {
            System.out.println();
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(bName) {
            System.out.print(new String(ch, start, length));
        } else if(bAge) {
            System.out.print(new String(ch, start, length));
        }
    }
}