import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_04641_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Step 2: Get a DocumentBuilder using the factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Step 3: Parse the XML file into a Document object
            Document doc = dBuilder.parse(new File("input.xml"));

            // Step 4: (Optional) Add your security-sensitive operations here (e.g., integrity checking)
            // For now, let's leave it as it is, as it's not specified in the problem.

            // Step 5: (Optional) Print the content of the Document object
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}