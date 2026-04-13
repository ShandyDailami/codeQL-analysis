import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;

public class java_18286_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            reader.setFeature("http://xml.org/sax/features/rational-numeric-data", true);

            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);

            reader.parse("test.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bValue = false;
    private String currentValue = null;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAIXException {
        if (qName.equalsIgnoreCase("name")) {
            bName = true;
        }
        if (qName.equalsIgnoreCase("value")) {
            bValue = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            bName = false;
        }
        if (qName.equalsIgnoreCase("value")) {
            bValue = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            currentValue = new String(ch, start, length);
        } else if (bValue) {
            currentValue += new String(ch, start, length);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Parsed document: " + currentValue);
    }
}