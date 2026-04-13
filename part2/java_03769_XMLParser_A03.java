import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_03769_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // TODO: Use the parsed document here.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}