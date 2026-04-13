import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_40904_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder for handling the XML document
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and create a DOM tree from it
            Document document = builder.parse(new File("sample.xml"));

            // Print out the document
            document.getDocumentElement().normalize();
            System.out.println("Root element: " + document.getDocumentElement().getNodeName());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}