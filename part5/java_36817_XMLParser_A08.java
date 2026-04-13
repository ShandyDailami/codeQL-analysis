import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_36817_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);
            System.out.println("XML file parsed successfully.");
        } catch (SAXException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading XML file: " + e.getMessage());
        }
    }
}