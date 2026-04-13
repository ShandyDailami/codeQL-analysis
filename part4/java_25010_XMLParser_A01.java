import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_25010_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            String filePath = "/path/to/your/xml/file.xml"; // Replace with your actual file path
            parseXMLFile(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXMLFile(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Create an instance of the DocumentBuilder
        Document doc = builder.parse(new File(filePath));

        // Get the root element of the document
        doc.getDocumentElement().normalize();

        // Print the name and age of the query element
        List<String> elements = doc.getElementsAsList();
        for (int i = 0; i < elements.size(); i++) {
            System.out.println("Element: " + elements.get(i));
        }
    }
}