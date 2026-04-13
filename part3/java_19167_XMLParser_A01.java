import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_19167_XMLParser_A01 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private boolean bCountry = false;
    private String name;
    private int age;
    private String country;

    public java_19167_XMLParser_A01() {
        super();
    }

    public void startDocument() {
        System.out.println("Start of document");
    }

    public void endDocument() {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("person".equals(qName)) {
            bName = true;
            bAge = true;
            bCountry = true;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("person".equals(qName)) {
            System.out.println("Name: " + name + ", Age: " + age + ", Country: " + country);
            bName = false;
            bAge = false;
            bCountry = false;
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (bName) {
            name = new String(ch, start, length);
            bName = false;
        } else if (bAge) {
            age = Integer.parseInt(new String(ch, start, length));
            bAge = false;
        } else if (bCountry) {
            country = new String(ch, start, length);
            bCountry = false;
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse("src/main/resources/people.xml", new SecureXMLParser());
    }
}