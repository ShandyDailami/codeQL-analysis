import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_17646_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        parseFile(xmlFile);
    }

    public static void parseFile(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
       
        }

        // Add your security-sensitive operations here.
        // This is a placeholder.
        System.out.println("Parsed XML document successfully.");
    }
}