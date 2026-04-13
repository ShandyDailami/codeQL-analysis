import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_32350_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory for reading the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("path/to/your/xml/file.xml"));

            // Here you can process the document, for example, print the XML tags
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}