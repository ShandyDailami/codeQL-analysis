import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_24892_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("input.xml"));

            // Extract the required data
            extractData(doc);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void extractData(Document doc) {
        // Retrieve the root element of the document
        Element root = doc.getDocumentElement();

        // Print the element name and its attribute value
        printElement(root);

        // Parse the XML document with a SAX parser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(new XMLReaderFactory().newFileXMLReader());

        // Process the XML document
        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File("input.xml"), myHandler);
    }

    // This method prints the name and attribute value of the element
    private static void printElement(Element element) {
        System.out.println("Name: " + element.getNodeName());

        // Print the attribute value
        NamedNodeMap attributes = element.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node attribute = attributes.item(i);
            System.out.println("Attribute: " + attribute.getNodeName() + " = " + attribute.getTextContent());
        }
    }

    // This is a handler for the SAX parser
    private static class MyHandler implements ContentHandler {
        public void startDocument() {
            System.out.println("Start of document");
        }

        public void endDocument() {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("Start of element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element: " + qName);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}