import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;

public class java_21801_XMLParser_A03 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String name = null;
    private int age = 0;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        }
        if (bName && qName.equalsIgnoreCase("name")) {
            bName = false;
        }
        if (bName && qName.equalsIgnoreCase("age")) {
            bAge = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            name = new String(ch, start, length);
        }
        if (bAge) {
            age = Integer.parseInt(new String(ch, start, length));
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Name: " + name + ", Age: " + age);
            bName = false;
            bAge = false;
            name = null;
            age = 0;
        }
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            MyXMLParser handler = new MyXMLParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);
            reader.parse(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}