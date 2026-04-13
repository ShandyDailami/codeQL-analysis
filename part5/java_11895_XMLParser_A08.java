import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_11895_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Here, you can parse the document and perform operations on it

        } catch (IOException e) {
            System.out.println("Error reading XML file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }
}