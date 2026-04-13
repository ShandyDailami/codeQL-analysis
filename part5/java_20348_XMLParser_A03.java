import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.XMLReader;

public class java_20348_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SAXParserHandler handler = new SAXParserHandler();
            reader.setContentHandler(handler);
            reader.parse("input.xml");  // replace with your XML file
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXParserHandler implements SAXHandler {
    private boolean isElement = false;
    private String currentElement = null;
    private String currentAttribute = null;
    private String currentValue = null;

    public void startElement(String uri, String localName, String qName) {
        isElement = true;
        currentElement = qName;
    }

    public void endElement(String uri, String localName, String qName) {
        isElement = false;
        currentElement = null;
    }

    public void startAttribute(String uri, String localName, String qName, String value) {
        isElement = true;
        currentAttribute = qName;
        currentValue = value;
    }

    public void endAttribute(String uri, String localName, String qName) {
        currentAttribute = null;
    }

    public void characters(String chars) {
        if (isElement) {
            System.out.println("Element: " + currentElement + ", Attribute: " + currentAttribute + ", Value: " + chars);
        }
    }
}