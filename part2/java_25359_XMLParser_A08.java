import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_25359_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a new DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use the builder to parse the XML file
            Document doc = builder.parse(new File("path_to_your_file.xml"));

            // Print out the XML file
            doc.getDocumentElement().normalize();
            System.out.println(doc.getElements());

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}