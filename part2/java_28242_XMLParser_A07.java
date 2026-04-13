import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_28242_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create an instance of the XML parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML file
            File inputFile = new File("input.xml");
            InputStream input = new FileInputStream(inputFile);
            Document document = builder.parse(input);

            // TODO: Handle the XML document...

            // Close the input stream
            input.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}