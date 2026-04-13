import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_22367_XMLParser_A03 extends DefaultHandler {

    private List<String> names = new ArrayList<>();
    private List<String> addresses = new ArrayList<>();

    public java_22367_XMLParser_A03() {
        super();
    }

    public void startDocument() throws SAXException {
        System.out.println("Start document.");
    }

    public void endDocument() throws SAXException {
        System.out.println("End document.");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("\nPerson Details : ");
            return;
        }

        if (qName.equalsIgnoreCase("name")) {
            names.add(attributes.getValue(""));
        }

        if (qName.equalsIgnoreCase("address")) {
            addresses.add(attributes.getValue(""));
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Name : " + names.get(0));
            System.out.println("Address : " + addresses.get(0));
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (names.size() < 2) {
            names.add(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserExample saxParser = new SAXParserExample();

        // Load your XML document here
        // For instance, you can use a SAX Parser to parse a XML file called "sample.xml"
        // YourXMLParser.parse("sample.xml", saxParser);

        // Uncomment the line below to parse your own XML file
        // YourXMLParser.parse("yourfile.xml", saxParser);
    }
}