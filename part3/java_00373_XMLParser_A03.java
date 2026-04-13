import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_00373_XMLParser_A03 extends DefaultHandler {

    private boolean bName;
    private boolean bAge;
    private String currentElement;

    public java_00373_XMLParser_A03() {
        this.bName = false;
        this.bAge = false;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (qName.equalsIgnoreCase("person")) {
            this.bName = true;
            this.bAge = true;
        } else {
            if (this.bName) {
                System.out.println("Name: " + localName);
                this.bName = false;
            } else if (this.bAge) {
                System.out.println("Age: " + localName);
                this.bAge = false;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (this.currentElement != null && this.currentElement.equalsIgnoreCase("name")) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (this.currentElement != null && this.currentElement.equalsIgnoreCase("age")) {
            System.out.println("Age: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\"?>\n" +
                "<people>\n" +
                "  <person>\n" +
                "    <name>John</name>\n" +
                "    <age>30</age>\n" +
                "  </person>\n" +
                "  <person>\n" +
                "    <name>Jane</name>\n" +
                "    <age>28</age>\n" +
                "  </person>\n" +
                "</people>";

        XmlParser handler = new XmlParser();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}