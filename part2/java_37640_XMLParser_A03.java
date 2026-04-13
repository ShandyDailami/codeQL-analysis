import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_37640_XMLParser_A03 {
    public static void main(String[] args) {
        String filePath = "/path/to/xml/file.xml";  // Replace with actual path
        parseFile(filePath);
    }

    public static void parseFile(String filePath) {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Here you can safely manipulate the parsed XML document
            // This is a basic example, real-world parsers would need more robust error handling and more features

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}