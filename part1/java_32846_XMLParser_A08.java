import java.io.FileInputStream;
import java.io.InputStream;
import java.xml.parsers.DocumentBuilderFactory;
import java.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;

public class java_32846_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory for handling xml content
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false); // Disable validation
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a reader for the input file
            InputStream inputStream = new FileInputStream("input.xml");

            // Parse the input file
            builder.parse(inputStream, null);

            System.out.println("The document is parsed successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}