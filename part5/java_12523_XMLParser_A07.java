import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_12523_XMLParser_A07 {

    public static void main(String[] args) {

        // Create a factory for building a new document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file into a DOM tree
            Document doc = builder.parse(new File("input.xml"));

            // Here you can manipulate the document
            // For example, print all elements and attributes
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}