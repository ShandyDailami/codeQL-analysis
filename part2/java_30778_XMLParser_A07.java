import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_30778_XMLParser_A07 {

    public static void main(String[] args) {
        // Create a SAX reader
        XMLReader reader = XMLReaderFactory.createXMLReader();

        // Create a custom handler
        AuthFailureHandler handler = new AuthFailureHandler();

        // Set the handler for the reader
        reader.setContentHandler(handler);

        // Parse the XML
        try {
            reader.parse("src/main/resources/example.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class AuthFailureHandler implements org.xml.sax.ContentHandler {

    @Override
    public void startDocument() {}

    @Override
    public void endDocument() {}

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("authFailure".equals(localName)) {
            System.out.println("AuthFailure detected!");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {}

    @Override
    public void characters(char[] ch, int start, int length) {}

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) {}

    @Override
    public void processingInstruction(String target, String data) {}

    @Override
    public void setElementNamespace(String uri, String prefix) {}

    @Override
    public void startPrefixMapping(String prefix, String uri) {}

    @Override
    public void endPrefixMapping(String prefix) {}
}