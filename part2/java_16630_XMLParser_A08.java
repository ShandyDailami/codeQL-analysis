// Import necessary libraries
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_16630_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the XML file
            Document doc = builder.parse(getXMLFile("sample.xml"));
            // Get the root element
            doc.getDocumentElement().normalize();
            // Print all the nodes
            printNodes(doc);
            // Print the integrity of the XML file
            System.out.println("Integrity: " + checkIntegrity(doc));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static File getXMLFile(String fileName) {
        ClassLoader classLoader = XMLParser.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return file;
    }

    private static void printNodes(Document doc) {
        // Traverse the DOM tree and print all the nodes
        doc.getChildNodes().forEach(node -> {
            System.out.println(node.getNodeName() + " : " + node.getTextContent());
        });
    }

    private static String checkIntegrity(Document doc) {
        // Implement security-sensitive operations related to integrity here
        // This is a placeholder for now
        return "Integrity Checked";
    }
}