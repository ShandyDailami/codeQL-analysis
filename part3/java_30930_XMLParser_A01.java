import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_30930_XMLParser_A01 {
    public static void main(String[] args) {
        String filePath = "path/to/your/file.xml"; // replace with your file path

        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            System.out.println("XML file parsed successfully.");
        } catch (IOException e) {
            System.out.println("Failed to parse XML file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Failed to parse XML file: " + e.getMessage());
        }
    }
}