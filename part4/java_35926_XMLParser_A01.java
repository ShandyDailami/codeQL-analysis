import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_35926_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory and use it to create a DocumentBuilder.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 2: Use the builder to parse the input file and store the result in a Document.
            Document doc = builder.parse(new File("input.xml"));

            // Here we should implement the security-sensitive operations related to A01_BrokenAccessControl.
            // For example, we can limit the user to only read the content of the XML file.

            // Print the content of the document.
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}