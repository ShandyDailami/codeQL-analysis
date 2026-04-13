import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_37262_XMLParser_A01 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml"); // Replace with your XML file path
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            Document doc = dBuilder.parse(inputFile);

            // Print out the contents of the XML file
            System.out.println("XML File Contents:");
            printDocument(doc);

            // Check if the XML file has a valid XML declaration
            if (!isValidXmlDeclaration(doc)) {
                System.out.println("The XML file does not have a valid XML declaration.");
            } else {
                System.out.println("The XML file does have a valid XML declaration.");
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        if (doc.hasChildNodes()) {
            for (Node node = doc.getFirstChild(); node != null; node = node.getNextSibling()) {
                System.out.println(node.getNodeName() + " : " + node.getTextContent());
            }
        }
    }

    private static boolean isValidXmlDeclaration(Document doc) {
        return doc.getXmlDeclarations().size() > 0;
    }
}