import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_05124_XMLParser_A01 {

    public static void main(String[] args) {
        // Create an instance of DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Create an instance of DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            // Parse the input file into a Document
            Document doc = builder.parse(new File("input.xml"));

            // Get the root element of the document
            Element root = doc.getDocumentElement();

            // Perform security-sensitive operations here
            // For example, accessing elements with incorrect names
            Element incorrectElement = root.getElementsByTagName("incorrect_name")
                    .item(0);

            // If the operation is successful, print a message
            System.out.println("Access to element " + incorrectElement.getNodeName() + " is not allowed");

        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}