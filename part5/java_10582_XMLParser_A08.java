import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.XMLReader;

public class java_10582_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            XMLReaderHandler handler = new XMLReaderHandler();
            reader.setContentHandler(handler);
            reader.parse("src/data.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class XMLReaderHandler implements XMLReader.ContentHandler {
    boolean isInElement = false;
    String elementData = "";

    public void startDocument() {
        // Not used
    }

    public void endDocument() {
        // Not used
    }

    public void startElement(String uri, String localName, String qName) {
        isInElement = true;
    }

    public void endElement(String uri, String localName, String qName) {
        isInElement = false;
        if ("element".equals(localName)) {
            System.out.println(elementData);
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (isInElement) {
            elementData = new String(ch, start, length);
        }
    }
}