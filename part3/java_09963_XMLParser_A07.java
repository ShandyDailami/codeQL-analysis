import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_09963_XMLParser_A07 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;

    public java_09963_XMLParser_A07() {
        super();
    }

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Start of person");
            bName = true;
            bAge = true;
            return;
        }
        if (bName) {
            System.out.print("Name: ");
            bName = false;
        }
        if (bAge) {
            System.out.print("Age: ");
            bAge = false;
        }
        System.out.print(localName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("End of person");
            return;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println(new String(ch, start, length));
            bName = false;
        }
        if (bAge) {
            System.out.println(new String(ch, start, length));
            bAge = false;
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyXMLParser());
            saxParser.parse(new InputSource(new StringReader("<people><person><name>John</name><age>25</age></person><person><name>Doe</name><age>20</age></person></people>")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}