import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_33198_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory and build a new Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("input.xml"));

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Print all the nodes
            printNodes(doc);

            // Parse and print SAX
            parseAndPrintSAX(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNodes(Document doc) {
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.println("Node: " + node.getNodeName());
        }
    }

    private static void parseAndPrintSAX(Document doc) {
        SAXParserHandler handler = new SAXParserHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(new InputSource(new StringReader(doc.getElementsByTagName("*").item(0).getTextContent())));
            parser.setContentHandler(handler);
            parser.parse(new InputSource(new StringReader(doc.getElementsByTagName("*").item(0).getTextContent())));
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}