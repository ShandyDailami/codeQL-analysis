import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_12949_XMLParser_A01 {
    public static void main(String[] args) {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("path_to_your_file.xml"));

            // Handle security-sensitive operations here (for example, print the document elements)
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            // Print all element names
            doc.getElementsByTagName("*").item(0).getChildNodes().item(0).normalize();
            System.out.println("\nAll element names:");
            for (int i = 0; i < doc.getElementsByTagName("*").item(0).getChildNodes().getLength(); i++) {
                System.out.println(doc.getElementsByTagName("*").item(0).getChildNodes().item(i).getNodeName());
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}