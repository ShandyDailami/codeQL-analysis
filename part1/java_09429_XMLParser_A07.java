import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_09429_XMLParser_A07 extends DefaultHandler {

    public void startDocument() {
        System.out.println("Start document...");
    }

    public void endDocument() {
        System.out.println("End document...");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End element: " + qName);
    }

    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public void error(SAXException e) {
        System.out.println("SAX Error: " + e.getMessage());
    }

    public void fatalError(SAXException e) {
        System.out.println("Fatal SAX Error: " + e.getMessage());
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        // Load the XML document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(ClassLoader.getSystemResourceAsStream("myxml.xml"));

        // Create the XML parser
        XMLReader reader = Documents.newXMLReader();
        reader.setContentHandler(new MyXMLHandler());

        // Parse the document
        reader.parse(new InputSource(new StringReader(doc.getTextContent())));
    }
}