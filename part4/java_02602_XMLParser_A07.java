import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;

public class java_02602_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a factory for the parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder for the XML document
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse("users.xml");

            // Print the user details
            printUserDetails(doc);

            // Create a new XML file with modified user details
            transformDocument(doc, "modified_users.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printUserDetails(Document doc) {
        // Select all user nodes
        NodeList users = doc.getElementsByTagName("user");

        // Print user details
        for (int i = 0; i < users.getLength(); i++) {
            System.out.println("User " + (i + 1) + ":");
            System.out.println("Name: " + users.item(i).getElementsByTagName("name").item(0).getTextContent());
            System.out.println("Password: " + users.item(i).getElementsByTagName("password").item(0).getTextContent());
            System.out.println();
        }
    }

    private static void transformDocument(Document doc, String outputFile) {
        // Create a transformer
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // Write the transformed document to the output file
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(outputFile);
        transformer.transform(source, result);
    }
}