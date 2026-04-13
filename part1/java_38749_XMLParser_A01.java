import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_38749_XMLParser_A01 {
    public static void main(String[] args) {
        String filePath = "path/to/your/file.xml";
        File xmlFile = new File(filePath);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;
        try {
            document = builder.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        // Continue with your code here, for example accessing elements or attributes
        // ...
    }
}