import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXReader;

public class java_18769_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a new SAXReader
            SAXReader reader = new SAXReader();

            // Create a new XMLReader
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            // Set the content handler
            xmlReader.setContentHandler(new MyContentHandler());

            // Parse the XML file
            xmlReader.parse("example.xml");

        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {
    public void startDocument() {}
    public void endDocument() {}
    public void startElement(String uri, String localName, String qName) {}
    public void endElement(String uri, String localName, String qName) {}
    public void characters(String chars) {}
    public void ignorableWhitespace(String text) {}
    public void processingInstruction(String target, String text) {}
    public void setElement(String uri, String localName, String qName,
                           String value) {}
}