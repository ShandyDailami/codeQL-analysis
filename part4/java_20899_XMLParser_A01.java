import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_20899_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document doc = builder.parse(new File("sample.xml"));

            // Print the XML document elements
            printDocument(doc);

        } catch (ParsingException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        // Start with XML declaration
        System.out.println("XML Declaration: " + doc.getXmlEncoding());

        // Get the document root element
        Element root = doc.getDocumentElement();
        System.out.println("Root Element: " + root.getNodeName());

        // Print all element names and values
        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element: " + element.getNodeName());
                System.out.println("Value: " + element.getTextContent());
            }
        }
    }
}