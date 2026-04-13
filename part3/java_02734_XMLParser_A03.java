import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_02734_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml"); // replace with your XML file
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodes = document.getElementsByTagName("node");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                System.out.println("Node " + (i + 1) + ": " + node.getTextContent());
           
                // Insert your security-sensitive operations here
                // For example, sanitizing input:
                String sanitizedInput = sanitizeInput(node.getTextContent());
                System.out.println("Sanitized input: " + sanitizedInput);
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String sanitizeInput(String input) {
        // Replace common injection techniques (like '<', '>', ';', etc.) with a placeholder
        // This is a very basic example and might not be suitable for all cases
        return input.replace("<", "")
                .replace(">", "")
                .replace(";", "");
    }
}