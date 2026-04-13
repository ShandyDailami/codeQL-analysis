import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_20743_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            String inputFile = "/path/to/your/file.xml"; // replace with your file path
            parseFile(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseFile(String inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try (InputStream input = new FileInputStream(inputFile)) {
            Document doc = builder.parse(input);

            // You can now use the DOM (Document Object Model) to manipulate the XML
            // For example, to print the XML's root element's tag name
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}