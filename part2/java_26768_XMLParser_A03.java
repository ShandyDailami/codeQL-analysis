import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_26768_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(xmlFile);

            // Here you can perform your operations on the document, e.g., accessing elements, attributes, text, etc.

            System.out.println("XML parsing successful!");
        } catch (Exception e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }
}