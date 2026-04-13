import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_24767_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // step 1: create a factory object
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // step 2: obtain a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // step 3: parse the XML file
            Document doc = builder.parse(new File("file.xml"));

            // Step 4: handle the document object
            // This step is not required for this example. It's a demonstration of how you might navigate the document.
            // In a real-world scenario, you'd replace this with code that accesses specific nodes or elements of the document.

            // Step 5: display the document
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}