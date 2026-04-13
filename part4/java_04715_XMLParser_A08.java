import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_04715_XMLParser_A08 extends DefaultHandler {

    private boolean bName;
    private boolean bAge;
    private String currentElement;
    
    public void startDocument() throws SAXException {
        System.out.println("Start document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
        if (qName.equalsIgnoreCase("name")) {
            bName = false;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        MyHandler handler = new MyHandler();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(new InputSource(new StringReader("<people><person><name>John</name><age>30</age></person><person><name>Doe</name><age>25</age></person></people>")), handler);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}