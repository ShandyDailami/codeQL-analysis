import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

public class java_05787_XMLParser_A03 extends BasicHandler {
    private boolean isInElement;
    private String currentElement;
    private String currentData;

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        isInElement = true;
        currentElement = qName;
        currentData = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isInElement = false;
        currentElement = qName;
        // Your security-sensitive operations here, like checking for injection attacks.
        // For now, just print the result.
        System.out.println(currentElement + ": " + currentData);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            currentData += new String(ch, start, length);
        }
    }

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyXMLParser());
            reader.parse("src/main/resources/injection.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}