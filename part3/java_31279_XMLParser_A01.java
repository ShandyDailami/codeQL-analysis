import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXParseException;

public class java_31279_XMLParser_A01 {

    public static void main(String[] args) {
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            SAXParserHandler handler = new SAXParserHandler();
            reader.setContentHandler(handler);
            reader.parse("sample.xml"); // replace with your xml file
            System.out.println("All elements and attributes: " + handler.getResult());
        } catch (SAXParseException e) {
            System.out.println("Parsing failed: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Problem configuring SAX: " + e.getMessage());
        }
    }
}

class SAXParserHandler implements javax.xml.parsers.SAXHandler {

    private StringBuilder result = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws SAXException {
        result.append("Element: ").append(qName).append("\n");
        if (attributes.getLength() > 0) {
            result.append("Attributes: ").append("\n");
            for (int i = 0; i < attributes.getLength(); i++) {
                result.append("\tName: ").append(attributes.getQName(i)).append(" Value: ").append(attributes.getValue(i)).append("\n");
            }
        }
        result.append("\n");
    }
}