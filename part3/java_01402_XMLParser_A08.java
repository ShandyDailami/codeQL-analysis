import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_01402_XMLParser_A08 {
    public static void main(String[] args) {
        // Create a factory for handling the parsers
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Get a builder instance for handling the document
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and create a new document
            Document doc = builder.parse(MinimalistXMLParser.class.getResourceAsStream("/sample.xml"));

            // Print out the XML document data
            printDocumentData(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDocumentData(Document doc) {
        // Print out the XML document data
        System.out.println("Document Title : " + doc.getDocumentElement().getTagName());

        // Get all elements
        Element root = doc.getDocumentElement();
        System.out.println("Root Element : " + root.getNodeName());

        // Get all children
        for (int i = 0; i < root.getChildNodes().getLength(); i++) {
            Element element = (Element) root.getChildNodes().item(i);
            System.out.println("Child Element : " + element.getNodeName() + " : " + element.getTextContent());
        }
    }
}