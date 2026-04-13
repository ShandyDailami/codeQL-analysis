import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_05706_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("input.xml"));

            // Step 2: Use the document
            // Here we are assuming that we only want to access the root element
            // You can access other elements and attributes as well
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}