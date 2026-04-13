import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_37236_XMLParser_A07 {
    public static void main(String[] args) {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create a DocumentBuilder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("path_to_your_file.xml"));

            // Handle the document here
            // For example, print out the document's root element and all its children
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            System.out.println("Child nodes:");
            for (int i = 0; i < doc.getDocumentElement().getChildNodes().getLength(); i++) {
                System.out.println(doc.getDocumentElement().getChildNodes().item(i).getNodeName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}