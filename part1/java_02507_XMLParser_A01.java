import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_02507_XMLParser_A01 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("example.xml"));

            // Print document elements and attributes
            doc.getElementsByTagName("*").item(0).getFirstChild().normalize();
            System.out.println("Root Element: " + doc.getElementsByTagName("*").item(0).getNodeName());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}