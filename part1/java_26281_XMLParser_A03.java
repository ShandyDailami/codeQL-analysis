import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_26281_XMLParser_A03 extends DefaultHandler {
    private String lastNodeName;
    private StringBuilder buffer;

    public java_26281_XMLParser_A03() {
        buffer = new StringBuilder();
    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        // This is where you would handle security-sensitive operations like SQL injection
        // But for the purpose of this example, we'll just print the name of the element
        buffer.setLength(0);
        buffer.append("Starting element: ");
        buffer.append(qName);
        System.out.println(buffer.toString());
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // Similar to the startElement method, we'll print the ending element
        buffer.setLength(0);
        buffer.append("Ending element: ");
        buffer.append(qName);
        System.out.println(buffer.toString());
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // Here we'll handle any text within the XML elements
        if (buffer.length() > 0) {
            buffer.setLength(0);
            buffer.append("Text within element: ");
            buffer.append(new String(ch, start, length));
            System.out.println(buffer.toString());
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        // Create a new instance of the XMLParser
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();

        // Create a new instance of our custom SAX parser
        MyXMLParser myParser = new MyXMLParser();
        xmlReader.setContentHandler(myParser);

        // Parse the XML document
        xmlReader.parse("src/main/resources/test.xml");
    }
}