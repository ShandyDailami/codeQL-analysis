import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_12532_XMLParser_A03 {

    public static void main(String[] args) {
        // The file to parse
        File inputFile = new File("input.xml");

        try {
            // Create a new instance of the DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the input file into a Document object
            Document doc = dBuilder.parse(inputFile);

            // Your code here...

        } catch (Exception e) {
            // Handle exceptions here...
            e.printStackTrace();
        }
    }
}