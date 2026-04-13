import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_31728_XMLParser_A08 {
    public static void main(String[] args) {
        // Load the XML document
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);

        // Start parsing
        XMLErrorHandler errorHandler = new XMLErrorHandler() {
            public void warning(SAXParseException e) {
                System.out.println("Warning: line " + e.getLineNumber() + " of file " + e.getSystemId() + ": " + e.getMessage());
            }
            public void error(SAXParseException e) {
                System.out.println("Error: line " + e.getLineNumber() + " of file " + e.getSystemId() + ": " + e.getMessage());
            }
            public void fatalError(SAXParseException e) {
                System.out.println("Fatal Error: line " + e.getLineNumber() + " of file " + e.getSystemId() + ": " + e.getMessage());
            }
        };

        XMLReader xReader = dBuilder.newSAXReader();
        xReader.setErrorHandler(errorHandler);

        // Parse the document
        MyHandler myHandler = new MyHandler();
        xReader.parse(new InputSource(new StringReader(doc.getDocumentElement().getTextContent())));

        // End parsing
    }
}

class MyHandler extends DefaultHandler {
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Handle the start of an element
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Handle the end of an element
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        // Handle characters inside elements
    }
}