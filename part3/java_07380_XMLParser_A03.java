import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_07380_XMLParser_A03 extends DefaultHandler {

    private boolean bName;
    private boolean bAge;
    private String currentElement;

    public java_07380_XMLParser_A03() {
        bName = false;
        bAge = false;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        currentElement = qualifiedName;

        if (localName.equals("Person")) {
            bName = true;
            bAge = true;
        } else {
            switch (localName) {
                case "Name":
                    bName = true;
                    break;
                case "Age":
                    bAge = true;
                    break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
        currentElement = null;

        if (localName.equals("Person")) {
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            String name = new String(ch, start, length);
            // Inject code here to prevent injection attacks
            System.out.println("Name: " + name);
        }

        if (bAge) {
            int age = Integer.parseInt(new String(ch, start, length));
            // Inject code here to prevent injection attacks
            System.out.println("Age: " + age);
        }
    }

    public static void main(String[] args) throws Exception {
        XMLParser parser = new XMLParser();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);
        saxParser.parse(new InputSource(new FileInputStream("src/people.xml")), parser);
    }
}