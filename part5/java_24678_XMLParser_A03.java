import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_24678_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create DocumentBuilder using factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file into a Document object
            Document doc = builder.parse(new FileInputStream("input.xml"));

            // TODO: Process the document (extract, manipulate, etc.)

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}