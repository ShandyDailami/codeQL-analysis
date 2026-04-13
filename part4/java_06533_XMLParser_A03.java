import org.xml.sax.SAXException;
import org.xml.sax.SAXParser;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_06533_XMLParser_A03 {

    public static void main(String[] args) {
        // Create a custom SAXHandler
        DefaultHandler customHandler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName,
                    Attributes attributes) throws SAXException {
                // Here you can inject code to perform security-sensitive operations.
                // For instance, you can store the attribute values in a String.
                String attributeValue = attributes.getValue("id");
                System.out.println("Attribute value: " + attributeValue);
            }
        };

        // Create a custom SAXParser
        SAXParser saxParser = XMLReaderFactory.createSAXParser(
                new StringReader("<document id='123'>Some XML content</document>"),
                customHandler);

        // Parse the XML file
        try {
            saxParser.parse("<?xml version='1.0' encoding='UTF-8'?>"
                    + "<root><child id='456'>Some more XML content</child></root>",
                    false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}