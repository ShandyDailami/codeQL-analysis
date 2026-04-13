import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_14130_XMLParser_A08 {

    public static void main(String[] args) {
        String filePath = "src/main/resources/sample.xml"; // replace with your file path
        parseFile(filePath);
    }

    private static void parseFile(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new File(filePath));
            // Your XML parsing code here
            // E.g., print all element names
            document.getElementsByTagName("*").item(0).getNodeName();
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}