import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_04658_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a new DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a new DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input xml file
            Document doc = builder.parse(getInputFile("input.xml"));

            // TODO: Perform security-sensitive operations related to A08_IntegrityFailure

            // TODO: Print the document

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static FileInputStream getInputFile(String fileName) {
        File file = new File(fileName);
        try {
            return new FileInputStream(file);
        } catch (Exception e) {
            System.out.println("Error occurred while trying to read input file.");
            e.printStackTrace();
        }
        return null;
    }
}