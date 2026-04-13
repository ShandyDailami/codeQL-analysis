import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_41379_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Create an instance of the XML file
            File file = new File("path_to_your_file.xml");
            
            // Parse the file
            Document document = builder.parse(file);
            
            // Print out the XML file
            document.getDocumentElement().normalize();
            System.out.println("Root element: " + document.getDocumentElement().getNodeName());
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}