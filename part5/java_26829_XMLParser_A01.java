import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_26829_XMLParser_A01 {
    private static final String XML_FILE_PATH = "path/to/your/xml/file.xml";

    public static void main(String[] args) {
        File xmlFile = new File(XML_FILE_PATH);

        try (InputStream xmlFileStream = new FileInputStream(xmlFile)) {
            parseXmlDocument(xmlFileStream);
        } catch (Exception e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }

    private static void parseXmlDocument(InputStream xmlFileStream) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try (InputStreamReader reader = new InputStreamReader(xmlFileStream)) {
            Document document = builder.parse(reader);

            // Print the parsed XML document (optional)
            System.out.println(document.toString());
        } catch (SAXException | IOException e) {
            System.out.println("Error parsing XML document: " + e.getMessage());
        }
    }
}